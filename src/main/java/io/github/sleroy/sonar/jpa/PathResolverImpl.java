package io.github.sleroy.sonar.jpa;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.sensor.SensorContext;

import java.io.File;
import java.util.Optional;

public class PathResolverImpl {
    private static final Logger LOG = LoggerFactory.getLogger(PathResolverImpl.class);

    /**
     * Tests if a path is existing.
     *
     * @param f the file
     * @return true if the file does exists
     */
    static boolean doesFileExist(File f) {
        return f.exists();
    }

    /**
     * Computes the absolute path of a resource from a string obtained from Sonar Properties
     *
     * @param context  the sensor context
     * @param path the path to check
     * @return the absolute resource path or null if the resource does not exist.
     */
    public Optional<String> getAbsolutePath(SensorContext context, String path) {
        if (path != null) {
            File candidateFile = new File(path);
            LOG.debug("#1 Trying to resolve path in {}", candidateFile);
            if (!candidateFile.isAbsolute()) {
                candidateFile = new File(context.fileSystem().baseDir().getAbsolutePath(), path);
                LOG.debug("#2 Trying to resolve path in {}", candidateFile);
            }

            if (!PathResolverImpl.doesFileExist(candidateFile)) {
                return Optional.empty();
            }

            return Optional.of(candidateFile.getAbsolutePath());
        }

        return Optional.empty();
    }
}
