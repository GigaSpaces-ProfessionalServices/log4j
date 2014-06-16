package com.gigaspaces.sbp;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceRouting;

/**
 * Created by IntelliJ IDEA.
 * User: jason
 * Date: 6/15/14
 * Time: 10:09 PM
 */
@SpaceClass
public class Pojo {

    private String spaceId;
    private Integer routingId;
    private String payload;
    private boolean processed;

    @SpaceId(autoGenerate = true)
    public String getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    @SpaceRouting
    public Integer getRoutingId() {
        return routingId;
    }

    public void setRoutingId(Integer routingId) {
        this.routingId = routingId;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public boolean getProcessed(){
        return isProcessed();
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pojo pojo = (Pojo) o;

        if (payload != null ? !payload.equals(pojo.payload) : pojo.payload != null) return false;
        if (routingId != null ? !routingId.equals(pojo.routingId) : pojo.routingId != null) return false;
        if (spaceId != null ? !spaceId.equals(pojo.spaceId) : pojo.spaceId != null) return false;

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = spaceId != null ? spaceId.hashCode() : 0;
        result = 31 * result + (routingId != null ? routingId.hashCode() : 0);
        result = 31 * result + (payload != null ? payload.hashCode() : 0);
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pojo{");
        sb.append("spaceId='").append(spaceId).append('\'');
        sb.append(", routingId=").append(routingId);
        sb.append(", payload='").append(payload).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
