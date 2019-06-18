package net.biberius.gradle.plugin.git


import org.eclipse.jgit.api.Git
import org.eclipse.jgit.transport.CredentialsProvider
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

class GitCloneTask extends DefaultTask {

    @Input
    Boolean bare    // Set whether the cloned repository shall be bare

    @Input
    String branch   // Set the initial branch

    @Input
    Collection<String> branchesToClone  // Set the branches or tags to clone.

    @Input
    Boolean cloneAllBranches    // Set whether all branches have to be fetched.

    @Input
    Boolean cloneSubmodules // Set whether to clone submodules

    @OutputDirectory
    File directory  // The optional directory associated with the clone operation.

    //FS fs   // Set the file system abstraction to be used for repositories created by this command.

    @OutputDirectory
    File gitDir // Set the repository meta directory (.git)

    @Input
    Boolean noCheckout  // Set whether to skip checking out a branch

    @Input
    String remote   // The remote name used to keep track of the upstream repository for the clone operation.

    @Input
    String uri  // Set the URI to clone from

    // CredentialsProvider credentialsProvider  // Set the credentialsProvider.
    /*
    AwtCredentialsProvider
    ChainingCredentialsProvider
    ConsoleCredentialsProvider
    NetRCCredentialsProvider
    SshTestHarness.TestCredentialsProvider
    UsernamePasswordCredentialsProvider
     */

    // int timeout // Set timeout.

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
        if (directory != null) {
            command.directory = directory
        }
        if (gitDir != null) {
            command.gitDir = gitDir
        }
        if (noCheckout != null) {
            command.noCheckout = noCheckout
        }
        if (remote != null) {
            command.remote = remote
        }
        if (uri != null) {
            command.uri = uri
        }
        def git = command.call()
    }

}
