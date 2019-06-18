package net.biberius.gradle.plugin.git

import org.gradle.api.Plugin
import org.gradle.api.Project

class GitPlugin implements Plugin<Project> {

    void apply(final Project project) {
        project.extensions.create('git', GitPluginExtension)

        project.tasks.register('gitClone', GitCloneTask)
        project.tasks.register('gitPull', GitPullTask)
    }
}
