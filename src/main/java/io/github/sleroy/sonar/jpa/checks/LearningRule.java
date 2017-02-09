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

import com.sonar.sslr.api.AstAndTokenVisitor;
import com.sonar.sslr.api.AstNode;
import com.sonar.sslr.api.AstNodeType;
import com.sonar.sslr.api.Token;
import org.sonar.check.Rule;
import org.sonar.check.RuleProperty;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.SyntaxToken;
import org.sonar.plugins.java.api.tree.ThrowStatementTree;

import javax.annotation.Nullable;
import java.util.List;

@Rule(key = "Clever")
public class LearningRule implements JavaFileScanner, AstAndTokenVisitor {

    private JavaFileScannerContext context;


    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;


    }

    @Override
    public void visitToken(Token token) {
        boolean contains = token.getValue().contains("@learn@");
        if (contains) {
            System.out.println(token);
        }
    }

    @Override
    public List<AstNodeType> getAstNodeTypesToVisit() {
        return null;
    }

    @Override
    public void visitFile(@Nullable AstNode astNode) {

    }

    @Override
    public void leaveFile(@Nullable AstNode astNode) {

    }

    @Override
    public void visitNode(AstNode astNode) {

    }

    @Override
    public void leaveNode(AstNode astNode) {

    }
}
