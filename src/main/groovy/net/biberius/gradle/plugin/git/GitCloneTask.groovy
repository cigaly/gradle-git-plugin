package net.biberius.gradle.plugin.git

import org.eclipse.jgit.api.Git
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class GitCloneTask extends DefaultTask {

    Boolean bare    // Set whether the cloned repository shall be bare

    String branch   // Set the initial branch

    Collection<String> branchesToClone  // Set the branches or tags to clone.

    Boolean cloneAllBranches    // Set whether all branches have to be fetched.

    Boolean cloneSubmodules // Set whether to clone submodules

    Boolean noCheckout  // Set whether to skip checking out a branch

    String remote   // The remote name used to keep track of the upstream repository for the clone operation.

    @TaskAction
    def gitClone() {
        def command = Git.cloneRepository()
        if (bare != null) {
            command.bare = bare
        }
        if (branch != null) {
            command.branch = branch
        }
        if (!branchesToClone?.isEmpty()) {
            command.branchesToClone = branchesToClone
        }
        if (cloneAllBranches != null) {
            command.cloneAllBranches = cloneAllBranches
        }
        if (cloneSubmodules != null) {
            command.cloneSubmodules = cloneSubmodules
        }
        if (this.project.extensions.git.directory != null) {
            command.directory = this.project.extensions.git.directory
        }
        if (this.project.extensions.git.gitDir != null) {
            command.gitDir = this.project.extensions.git.gitDir
        }
        if (noCheckout != null) {
            command.noCheckout = noCheckout
        }
        if (remote != null) {
            command.remote = remote
        }
        if (this.project.extensions.git.uri != null) {
            command.uri = this.project.extensions.git.uri
        }
        def git = command.call()
    }

}
