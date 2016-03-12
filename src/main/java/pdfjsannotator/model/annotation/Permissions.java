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

import javax.persistence.Embeddable;

@Embeddable
public class Permissions {

    String[] read;
    String[] admin;
    String[] update;
    String[] delete;

    public Permissions() {
        this.read = new String[]{"group:__world__"};
        this.admin = new String[]{"group:__world__"};
        this.update = new String[]{"group:__world__"};
        this.delete = new String[]{"group:__world__"};
    }

    public Permissions(String[] read, String[] admin, String[] update, String[] delete) {
        this.read = read;
        this.admin = admin;
        this.update = update;
        this.delete = delete;
    }

    public String[] getRead() {
        return read;
    }

    public void setRead(String[] read) {
        this.read = read;
    }

    public String[] getAdmin() {
        return admin;
    }

    public void setAdmin(String[] admin) {
        this.admin = admin;
    }

    public String[] getUpdate() {
        return update;
    }

    public void setUpdate(String[] update) {
        this.update = update;
    }

    public String[] getDelete() {
        return delete;
    }

    public void setDelete(String[] delete) {
        this.delete = delete;
    }
}
