/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Mathias Lin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package pdfjsannotator.model.annotation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
public class Annotation {

    @Id
    String id;
    String annotator_schema_version;
    Timestamp created;
    Timestamp updated;
    @Size(max = 200000)
    String text;
    @Size(max = 200000)
    String quote;
    @Size(max = 2000)
    String uri;
    @Transient
    Range[] ranges;
    Range range;
    String user1;
    String consumer;
    String[] tags = new String[]{};
    @Transient
    Permissions permissions = new Permissions();

    public Annotation() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAnnotator_schema_version() {
        return annotator_schema_version;
    }

    public void setAnnotator_schema_version(String annotator_schema_version) {
        this.annotator_schema_version = annotator_schema_version;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Range[] getRanges() {
        if (ranges == null || ranges.length == 0) {
            ranges = new Range[]{range};
        }
        return ranges;
    }

    public void setRanges(Range[] ranges) {
        this.ranges = ranges;
        if (this.ranges.length > 0) {
            this.range = ranges[0];
        }
    }

    public String getUser1() {
        return user1;
    }

    public void setUser1(String user) {
        this.user1 = user;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public String[] getTags() {
        if (tags == null) {
            tags = new String[]{};
        }
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }

    public Permissions getPermissions() {
        if (permissions == null) {
            permissions = new Permissions();
        }
        return permissions;
    }

    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
    }
}
