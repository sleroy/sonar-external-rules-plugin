/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.sleroy.sonar.jpa.checks;

import java.util.List;
import org.sonar.plugins.java.api.tree.AnnotationTree;
import org.sonar.plugins.java.api.tree.IdentifierTree;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;

/**
 *
 * @author sleroy
 */
class ASTUtils {

    /**
     * Tests if the method has the following annotation.
     * @param methodTree the method tree
     * @param requestMapping the request mapping.
     * @return 
     */
    static boolean hasMethodAnnotation(MethodTree methodTree, String requestMapping) {
        List<AnnotationTree> annotations = methodTree.modifiers().annotations();
        for (AnnotationTree annotationTree : annotations) {
            if (annotationTree.annotationType().is(Tree.Kind.IDENTIFIER)) {
                IdentifierTree idf = (IdentifierTree) annotationTree.annotationType();
                System.out.println(idf.name());

                if (requestMapping.matches(idf.name())) {
                    return true; // Annotation found
                }
            }
        }
        return false;

    }

}
