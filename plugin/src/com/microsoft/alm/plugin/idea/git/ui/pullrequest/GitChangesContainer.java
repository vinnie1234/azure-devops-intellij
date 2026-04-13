// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See License.txt in the project root.

package com.microsoft.alm.plugin.idea.git.ui.pullrequest;

import git4idea.repo.GitRepository;

/**
 * This class wraps the BranchCompareInfo object and the information about which branches and commit hashes were
 * compared
 */
public class GitChangesContainer {

    private String sourceBranchName;
    private String targetBranchName;
    private String sourceBranchHash;
    private String targetBranchHash;
    private BranchCompareInfo gitCommitCompareInfo;
    private GitRepository gitRepository;

    public static GitChangesContainer createChangesContainer(final String sourceBranchName, final String targetBranchName,
                                                             final String sourceBranchHash, final String targetBranchHash,
                                                             final BranchCompareInfo gitCommitCompareInfo,
                                                             final GitRepository gitRepository) {
        final GitChangesContainer container = new GitChangesContainer();
        container.setSourceBranchName(sourceBranchName);
        container.setSourceBranchHash(sourceBranchHash);
        container.setTargetBranchName(targetBranchName);
        container.setTargetBranchHash(targetBranchHash);
        container.setBranchCompareInfo(gitCommitCompareInfo);
        container.setGitRepository(gitRepository);

        return container;
    }

    public String getSourceBranchName() {
        return sourceBranchName;
    }

    public void setSourceBranchName(final String sourceBranchName) {
        this.sourceBranchName = sourceBranchName;
    }

    public String getTargetBranchName() {
        return targetBranchName;
    }

    public void setTargetBranchName(final String targetBranchName) {
        this.targetBranchName = targetBranchName;
    }

    public String getSourceBranchHash() {
        return sourceBranchHash;
    }

    public void setSourceBranchHash(final String sourceBranchHash) {
        this.sourceBranchHash = sourceBranchHash;
    }

    public String getTargetBranchHash() {
        return targetBranchHash;
    }

    public void setTargetBranchHash(final String targetBranchHash) {
        this.targetBranchHash = targetBranchHash;
    }

    public BranchCompareInfo getBranchCompareInfo() {
        return gitCommitCompareInfo;
    }

    public void setBranchCompareInfo(final BranchCompareInfo gitCommitCompareInfo) {
        this.gitCommitCompareInfo = gitCommitCompareInfo;
    }

    public GitRepository getGitRepository() {
        return gitRepository;
    }

    public void setGitRepository(final GitRepository gitRepository) {
        this.gitRepository = gitRepository;
    }
}
