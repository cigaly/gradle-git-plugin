package net.biberius.gradle.plugin.git

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

import static org.junit.Assert.assertTrue


class GitCloneTaskTest {

    @Test
    void testClone() {
        Project project = ProjectBuilder.builder().build()
        project.pluginManager.apply 'net.biberius.gradle-git-plugin'

        def tmpDir = new File(project.buildDir, 'tmp')
        tmpDir.mkdirs()
        def directory = new File(tmpDir, 'test-clone')
        project.extensions.git.directory = directory

        directory.deleteDir()

        project.extensions.git.uri = 'git@github.com:cigaly/gradle-git-plugin.git'

        def task = project.tasks.gitClone
        assertTrue(task instanceof GitCloneTask)
        task.gitClone()

    }

}
