package com.oracle.xmlns.apps.shared;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ObjectList<T extends Object> {

    @SerializedName("items")
    @Expose
    private List<T> items = null;
    @SerializedName("count")
    @Expose
    private long count;
    @SerializedName("hasMore")
    @Expose
    private boolean hasMore;
    @SerializedName("limit")
    @Expose
    private long limit;
    @SerializedName("offset")
    @Expose
    private long offset;
    @SerializedName("links")
    @Expose
    private List<Link> links = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public ObjectList() {
    }

    /**
     *
     * @param limit
     * @param hasMore
     * @param count
     * @param items
     * @param links
     * @param offset
     */
    public ObjectList(List<T> items, long count, boolean hasMore, long limit, long offset, List<Link> links) {
        super();
        this.items = items;
        this.count = count;
        this.hasMore = hasMore;
        this.limit = limit;
        this.offset = offset;
        this.links = links;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

}
