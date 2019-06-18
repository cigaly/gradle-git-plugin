package net.biberius.gradle.plugin.git

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

import static org.junit.Assert.assertTrue


class GitCloneTaskTest {

    @Test
    void testClone() {
        Project project = ProjectBuilder.builder().build()
        def task = project.task('gitClone', type: GitCloneTask)
        assertTrue(task instanceof GitCloneTask)
        def tmpDir = new File(project.buildDir, 'tmp')
        tmpDir.mkdirs()
        def directory = new File(tmpDir, 'test-clone')
        def deleteDir = directory.deleteDir()
        task.directory = directory
        task.uri = 'git@github.com:cigaly/gradle-git-plugin.git'
        task.gitClone()

    }

}
