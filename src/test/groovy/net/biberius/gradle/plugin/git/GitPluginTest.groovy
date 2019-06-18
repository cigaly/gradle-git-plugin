package net.biberius.gradle.plugin.git

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

import static org.junit.Assert.assertTrue

class GitPluginTest {

    @Test
    public void greeterPluginAddsGreetingTaskToProject() {
        Project project = ProjectBuilder.builder().build()
        project.pluginManager.apply 'net.biberius.gradle-git-plugin'

        assertTrue(project.tasks.gitClone instanceof GitCloneTask)
        assertTrue(project.tasks.gitPull instanceof GitPullTask)
    }

}
