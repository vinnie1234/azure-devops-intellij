// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See License.txt in the project root.

package com.microsoft.alm.plugin.external.models;

import com.microsoft.tfs.model.connector.TfsServerStatusType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Server status types
 */
public enum ServerStatusType {
    ADD,
    RENAME,
    EDIT,
    DELETE,
    UNDELETE,
    LOCK,
    BRANCH,
    MERGE,
    UNKNOWN;

    public static final Logger logger = LoggerFactory.getLogger(ServerStatusType.class);
    public static final String SOURCE_RENAME = "source rename";
    public static final String PROPERTY_X = "property (+x)";

    /**
     * Figure out server status type from string
     *
     * @param statusString
     * @return
     */
    public static List<ServerStatusType> getServerStatusTypes(final String statusString) {
        final String[] args = statusString.split(",");
        final List<ServerStatusType> types = new ArrayList<ServerStatusType>(args.length);

        for (int i = 0; i < args.length; i++) {
            String trimmed = args[i].trim();
            if ((trimmed == null ? ADD.name() == null : trimmed.equalsIgnoreCase(ADD.name()))) {
                types.add(ADD);
            } else if ((trimmed == null ? DELETE.name() == null : trimmed.equalsIgnoreCase(DELETE.name()))) {
                types.add(DELETE);
            } else if ((trimmed == null ? EDIT.name() == null : trimmed.equalsIgnoreCase(EDIT.name())) || (trimmed == null ? PROPERTY_X == null : trimmed.equalsIgnoreCase(PROPERTY_X))) {
                types.add(EDIT);
            } else if ((trimmed == null ? RENAME.name() == null : trimmed.equalsIgnoreCase(RENAME.name())) || (trimmed == null ? SOURCE_RENAME == null : trimmed.equalsIgnoreCase(SOURCE_RENAME))) {
                types.add(RENAME);
            } else if ((trimmed == null ? UNDELETE.name() == null : trimmed.equalsIgnoreCase(UNDELETE.name()))) {
                types.add(UNDELETE);
            } else if ((trimmed != null && trimmed.toLowerCase().contains(LOCK.name().toLowerCase()))) {
                types.add(LOCK);
            } else if ((trimmed != null && trimmed.toLowerCase().contains(BRANCH.name().toLowerCase()))) {
                types.add(BRANCH);
            } else if ((trimmed != null && trimmed.toLowerCase().contains(MERGE.name().toLowerCase()))) {
                types.add(MERGE);
            } else {
                logger.error("Undocumented status from server: " + args[i]);
                types.add(UNKNOWN);
            }
        }
        return types;
    }

    public static ServerStatusType from(TfsServerStatusType type) {
        switch (type) {
            case ADD:
                return ADD;
            case RENAME:
                return RENAME;
            case EDIT:
                return EDIT;
            case DELETE:
                return DELETE;
            case UNDELETE:
                return UNDELETE;
            case LOCK:
                return LOCK;
            case BRANCH:
                return BRANCH;
            case MERGE:
                return MERGE;
            case UNKNOWN:
            default:
                return UNKNOWN;
        }
    }
}