/*
 * SonarQube Java Custom Rules Example
 * Copyright (C) 2016-2016 SonarSource SA
 * mailto:contact AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package io.github.sleroy.sonar.jpa.checks;

import org.sonar.check.Rule;
import org.sonar.check.RuleProperty;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.AnnotationTree;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.IdentifierTree;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;

import java.util.List;

@Rule(key = "NotProtectedRestResource")
public class NotProtectedRestResourceRule extends BaseTreeVisitor implements JavaFileScanner {

    private static final String DEFAULT_VALUE = "RequestMapping, Get, Put, Post, Delete";

    private JavaFileScannerContext context;

    /**
     * Name of the annotation to avoid. Value can be set by users in Quality
     * profiles. The key
     */
    @RuleProperty(
            defaultValue = DEFAULT_VALUE,
            description = "Annotations indicating rest resources")
    protected String restAnnotations;
    private StringMatcher matcher;

    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;
        matcher = new StringMatcher(restAnnotations);
        scan(context.getTree());

    }

    @Override
    public void visitMethod(MethodTree tree) {

        if (ASTUtils.hasMethodAnnotation(tree, "RequestMapping")) {
            if (!ASTUtils.hasMethodAnnotation(tree, "Secured")) {
                final String message = String.format("Unsecured Request Mapping, the request mapping should be associated with a @Secured annotation.");
                System.out.println(message);
                context.reportIssue(this, tree, message);
            }
        }

        // The call to the super implementation allows to continue the visit of the AST.
        // Be careful to always call this method to visit every node of the tree.
        super.visitMethod(tree);
    }
}
