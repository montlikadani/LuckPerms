/*
 * This file is part of LuckPerms, licensed under the MIT License.
 *
 *  Copyright (c) lucko (Luck) <luck@lucko.me>
 *  Copyright (c) contributors
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package me.lucko.luckperms.api;

import java.util.SortedMap;
import java.util.SortedSet;
import java.util.UUID;

import javax.annotation.Nonnull;

/**
 * Represents the internal LuckPerms log.
 *
 * <p>The returned instance provides a copy of the data at the time of retrieval. Any changes made to log entries will
 * only apply to this instance of the log. You can add to the log using the {@link Storage}, and then request an updated copy.</p>
 */
public interface Log {

    /**
     * @return a {@link SortedSet} of all of the {@link LogEntry} objects in this {@link Log}
     */
    @Nonnull
    SortedSet<LogEntry> getContent();

    /**
     * @return all content in this log
     */
    @Nonnull
    SortedSet<LogEntry> getRecent();

    /**
     * Gets the recent content separated by page
     *
     * @param pageNo the page number
     * @return the page content
     * @throws IllegalArgumentException if the pageNo is less than 1
     * @throws IllegalStateException if the log doesn't contain enough entries to populate the page. See {@link #getRecentMaxPages()}}
     */
    @Nonnull
    SortedMap<Integer, LogEntry> getRecent(int pageNo);

    /**
     * @return the max page number allowed in the {@link #getRecent(int)} method
     */
    int getRecentMaxPages();


    /**
     * @param actor the uuid of the actor to filter by
     * @return all content in this log where is actor = uuid
     */
    @Nonnull
    SortedSet<LogEntry> getRecent(@Nonnull UUID actor);

    /**
     * Gets the recent content for the uuid, separated into pages
     *
     * @param pageNo the page number
     * @param actor  the uuid of the actor to filter by
     * @return the page content
     * @throws IllegalArgumentException if the pageNo is less than 1
     * @throws IllegalStateException if the log doesn't contain enough entries to populate the page. See {@link #getRecentMaxPages(UUID)}}
     */
    @Nonnull
    SortedMap<Integer, LogEntry> getRecent(int pageNo, @Nonnull UUID actor);

    /**
     * @param actor the actor to filter by
     * @return the max page number allowed in the {@link #getRecent(int, UUID)} method
     */
    int getRecentMaxPages(@Nonnull UUID actor);


    /**
     * @param uuid the uuid to filter by
     * @return all content in this log where the user = uuid
     */
    @Nonnull
    SortedSet<LogEntry> getUserHistory(@Nonnull UUID uuid);

    /**
     * Gets the user history content, separated by pages
     *
     * @param pageNo the page number
     * @param uuid   the uuid of the acted user to filter by
     * @return the page content
     * @throws IllegalArgumentException if the pageNo is less than 1
     * @throws IllegalStateException if the log doesn't contain enough entries to populate the page. See {@link #getUserHistoryMaxPages(UUID)}}
     */
    @Nonnull
    SortedMap<Integer, LogEntry> getUserHistory(int pageNo, @Nonnull UUID uuid);

    /**
     * @param uuid the uuid to filter by
     * @return the max page number allowed in the {@link #getUserHistory(int, UUID)} method
     */
    int getUserHistoryMaxPages(@Nonnull UUID uuid);


    /**
     * @param name the name to filter by
     * @return all content in this log where the group = name
     */
    @Nonnull
    SortedSet<LogEntry> getGroupHistory(@Nonnull String name);

    /**
     * Gets the group history content, separated by pages
     *
     * @param pageNo the page number
     * @param name   the name of the acted group to filter by
     * @return the page content
     * @throws IllegalArgumentException if the pageNo is less than 1
     * @throws IllegalStateException if the log doesn't contain enough entries to populate the page. See {@link #getGroupHistoryMaxPages(String)}}
     */
    @Nonnull
    SortedMap<Integer, LogEntry> getGroupHistory(int pageNo, @Nonnull String name);

    /**
     * @param name the name to filter by
     * @return the max page number allowed in the {@link #getGroupHistory(int, String)} method
     */
    int getGroupHistoryMaxPages(@Nonnull String name);


    /**
     * @param name the name to filter by
     * @return all content in this log where the track = name
     */
    @Nonnull
    SortedSet<LogEntry> getTrackHistory(@Nonnull String name);

    /**
     * Gets the track history content, separated by pages
     *
     * @param pageNo the page number
     * @param name   the name of the acted track to filter by
     * @return the page content
     */
    @Nonnull
    SortedMap<Integer, LogEntry> getTrackHistory(int pageNo, @Nonnull String name);

    /**
     * @param name the name to filter by
     * @return the max page number allowed in the {@link #getTrackHistory(int, String)} method
     * @throws IllegalArgumentException if the pageNo is less than 1
     * @throws IllegalStateException if the log doesn't contain enough entries to populate the page. See {@link #getTrackHistoryMaxPages(String)}}
     */
    int getTrackHistoryMaxPages(@Nonnull String name);


    /**
     * @param query the query to filter by
     * @return all content in this log where the content matches query
     */
    @Nonnull
    SortedSet<LogEntry> getSearch(@Nonnull String query);

    /**
     * Gets the search content, separated by pages
     *
     * @param pageNo the page number
     * @param query  the query to filter by
     * @return the page content
     * @throws IllegalArgumentException if the pageNo is less than 1
     * @throws IllegalStateException if the log doesn't contain enough entries to populate the page. See {@link #getSearchMaxPages(String)}}
     */
    @Nonnull
    SortedMap<Integer, LogEntry> getSearch(int pageNo, @Nonnull String query);

    /**
     * @param query the query to filter by
     * @return the max page number allowed in the {@link #getSearch(int, String)} method
     */
    int getSearchMaxPages(@Nonnull String query);
}
