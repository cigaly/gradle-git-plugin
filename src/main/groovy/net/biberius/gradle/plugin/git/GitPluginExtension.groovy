package net.biberius.gradle.plugin.git

class GitPluginExtension {

    String uri  // Set the URI to clone from

    File directory  // The optional directory associated with the clone operation.

    File gitDir // Set the repository meta directory (.git)

}
