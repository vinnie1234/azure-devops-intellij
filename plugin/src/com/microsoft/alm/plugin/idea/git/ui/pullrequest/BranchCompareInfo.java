// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See License.txt in the project root.

package com.microsoft.alm.plugin.idea.git.ui.pullrequest;

import com.intellij.openapi.util.Pair;
import com.intellij.openapi.vcs.changes.Change;
import git4idea.GitCommit;
import git4idea.repo.GitRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Stores branch comparison data (commits and file changes) between two branches.
 * Replaces the removed git4idea.util.GitCommitCompareInfo class (removed in IntelliJ 261+).
 */
public class BranchCompareInfo {

    private List<GitCommit> branchToHeadCommits = new ArrayList<GitCommit>();
    private List<Change> totalDiff = new ArrayList<Change>();

    public BranchCompareInfo() {
    }

    public void put(final GitRepository repository, final Collection<Change> diff) {
        totalDiff = new ArrayList<Change>(diff);
    }

    public void put(final GitRepository repository, final Pair<List<GitCommit>, List<GitCommit>> commitsPair) {
        // commitsPair.second = git log <commonParent>.. = commits on current branch since common ancestor
        branchToHeadCommits = commitsPair.second != null ? commitsPair.second : Collections.<GitCommit>emptyList();
    }

    public List<GitCommit> getBranchToHeadCommits(final GitRepository repository) {
        return Collections.unmodifiableList(branchToHeadCommits);
    }

    public List<Change> getTotalDiff() {
        return Collections.unmodifiableList(totalDiff);
    }
}
