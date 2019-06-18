package net.biberius.gradle.plugin.git

import org.eclipse.jgit.api.Git
import org.eclipse.jgit.api.MergeCommand.FastForwardMode
import org.eclipse.jgit.lib.BranchConfig.BranchRebaseMode
import org.eclipse.jgit.lib.SubmoduleConfig.FetchRecurseSubmodulesMode
import org.eclipse.jgit.merge.MergeStrategy
import org.eclipse.jgit.storage.file.FileRepositoryBuilder
import org.eclipse.jgit.transport.TagOpt
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.TaskAction

class GitPullTask extends DefaultTask {

    @InputDirectory
    File gitDir

    @Input
    FastForwardMode fastForwardMode    // Set the fast forward mode.

    @Input
    Boolean useRebase   // Set if rebase should be used after fetching.

    @Input
    BranchRebaseMode rebaseMode    // Sets the BranchConfig.BranchRebaseMode to use after fetching.

    @Input
    FetchRecurseSubmodulesMode recurse  // Set the mode to be used for recursing into submodules.

    @Input
    String remote   // The remote (uri or name) to be used for the pull operation.

    @Input
    String remoteBranchName // The remote branch name to be used for the pull operation.

    @Input
    MergeStrategy strategy  // Set the @{code MergeStrategy}

    @Input
    TagOpt tagOpt   // Set the specification of annotated tag behavior during fetch

    @TaskAction
    def gitPull() {
        FileRepositoryBuilder s1 = new FileRepositoryBuilder() //
                .setGitDir(gitDir)
        def repository = s1 // --git-dir if supplied, no-op if null
                .readEnviroment() // scan environment GIT_* variables
                .findGitDir() // scan up the file system tree
                .build()
        def git = new Git(repository)
        def pull = git.pull()
        pull.call()
    }

}
