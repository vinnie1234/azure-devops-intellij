// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See License.txt in the project root.

package com.microsoft.alm.plugin.idea.tfvc.ui.servertree;

// TODO: Migrate to AsyncTreeModel and StructureTreeModel APIs
// AbstractTreeBuilder was deprecated and removed in IntelliJ 2025.2
// import com.intellij.ide.util.treeView.AbstractTreeBuilder;
// import com.intellij.ide.util.treeView.AbstractTreeStructure;
// import com.intellij.ide.util.treeView.NodeDescriptor;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.Disposable;
// import com.intellij.ui.treeStructure.SimpleTreeStructure;
import org.jetbrains.annotations.NotNull;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
// import java.util.Comparator;

// TODO: Replace AbstractTreeBuilder with modern AsyncTreeModel approach
public class TfsTreeBuilder implements Disposable /* extends AbstractTreeBuilder */ {
    private static final Logger LOG = Logger.getInstance(TfsTreeBuilder.class.getName());

    // TODO: Restore NodeDescriptor comparator when migrating to modern tree API
    // private static final Comparator<NodeDescriptor> COMPARATOR = new Comparator<NodeDescriptor>() {
    //     public int compare(NodeDescriptor o1, NodeDescriptor o2) {
    //         if (o1 instanceof TfsErrorTreeNode) {
    //             return o2 instanceof TfsErrorTreeNode ? ((TfsErrorTreeNode) o1).getMessage().compareTo(((TfsErrorTreeNode) o2).getMessage()) : -1;
    //         } else if (o2 instanceof TfsErrorTreeNode) {
    //             return 1;
    //         }
    //
    //         final TfsTreeNode n1 = (TfsTreeNode) o1;
    //         final TfsTreeNode n2 = (TfsTreeNode) o2;
    //         if (n1.isDirectory() && !n2.isDirectory()) {
    //             return -1;
    //         } else if (!n1.isDirectory() && n2.isDirectory()) {
    //             return 1;
    //         }
    //
    //         return n1.getFileName().compareToIgnoreCase(n2.getFileName());
    //     }
    // };

    // TODO: Replace with AsyncTreeModel-based implementation
    public static TfsTreeBuilder createInstance(@NotNull final TfsTreeNode root, @NotNull final JTree tree) {
        final DefaultTreeModel treeModel = new DefaultTreeModel(new DefaultMutableTreeNode(root));
        tree.setModel(treeModel);
        return new TfsTreeBuilder(tree, treeModel);
    }

    private final JTree tree;
    private final DefaultTreeModel treeModel;

    public TfsTreeBuilder(final JTree tree, final DefaultTreeModel treeModel) {
        this.tree = tree;
        this.treeModel = treeModel;
    }

    // TODO: Implement modern tree building methods when migrating to AsyncTreeModel
    // Placeholder methods to maintain compatibility
    public void select(Object element) {
        // TODO: Implement selection logic
    }

    public java.util.Set<Object> getSelectedElements() {
        // TODO: Implement selection retrieval
        return new java.util.HashSet<>();
    }

    public com.intellij.openapi.util.ActionCallback queueUpdateFrom(Object element, boolean updateStructure) {
        // TODO: Implement update logic
        return com.intellij.openapi.util.ActionCallback.DONE;
    }
    
    @Override
    public void dispose() {
        // TODO: Implement proper disposal when migrating to AsyncTreeModel
    }

    // Commented out original AbstractTreeBuilder-based methods
    // TODO: Migrate these to AsyncTreeModel approach
    //
    // @Override
    // protected void runBackgroundLoading(@NotNull final Runnable runnable) {
    //     if (isDisposed()) return;
    //     runnable.run();
    // }
    //
    // @Override
    // protected boolean isAutoExpandNode(final NodeDescriptor nodeDescriptor) {
    //     if (nodeDescriptor instanceof TfsErrorTreeNode) {
    //         return true;
    //     }
    //     if (nodeDescriptor instanceof TfsTreeNode) {
    //         return !((TfsTreeNode) nodeDescriptor).isDirectory() || ((TfsTreeNode) nodeDescriptor).isRoot();
    //     }
    //     return false;
    // }
    //
    // @Override
    // protected boolean isAlwaysShowPlus(final NodeDescriptor descriptor) {
    //     if (descriptor instanceof TfsTreeNode) {
    //         return ((TfsTreeNode) descriptor).isDirectory();
    //     } else {
    //         LOG.assertTrue(descriptor instanceof TfsErrorTreeNode);
    //         return false;
    //     }
    // }
}
