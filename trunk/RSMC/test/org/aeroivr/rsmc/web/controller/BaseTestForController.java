/*
 * BaseTestForController.java
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * version 2 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 */

package org.aeroivr.rsmc.web.controller;

import java.io.PrintWriter;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import junit.framework.TestCase;
import org.aeroivr.rsmc.common.*;
import org.easymock.classextension.IMocksControl;
import static org.easymock.classextension.EasyMock.createNiceControl;
import static org.easymock.classextension.EasyMock.expectLastCall;
import static org.easymock.classextension.EasyMock.eq;
import static org.easymock.classextension.EasyMock.contains;
import static org.easymock.classextension.EasyMock.and;

/**
 *
 * @author Andriy Petlyovanyy
 */
public class BaseTestForController extends TestCase {

    public BaseTestForController(final String testName) {
        super(testName);
    }

    public class PageGetTestParameters<T> {
        public IMocksControl control;
        public HttpServletRequest requestMock;
        public HttpServletResponse responseMock;
        public PrintWriter printWriterMock;
        public T controllerMock;
    }

    public <T extends BasePageController> void pageGetInitTest(
            Class<T> controllerClass, PageGetTestParameters<T> testParams)
                throws Exception {

        testParams.control = createNiceControl();
        testParams.requestMock = testParams.control.createMock(
                HttpServletRequest.class);
        testParams.responseMock = testParams.control.createMock(
                HttpServletResponse.class);
        testParams.printWriterMock = testParams.control.createMock(
                PrintWriter.class);
        testParams.controllerMock = testParams.control.createMock(
                    controllerClass,
                    new Method[] {
                BasePageController.class.getDeclaredMethod(
                        "getViewsFolder"),
                BasePageController.class.getDeclaredMethod("clearErrors")});

        testParams.controllerMock.getViewsFolder();
        expectLastCall().andReturn(TestConstants.VIEWS_FOLDER).atLeastOnce();

        testParams.requestMock.getContextPath();
        expectLastCall().andReturn(
                TestConstants.SERVLET_CONTEXT_PATH).atLeastOnce();

        testParams.responseMock.getWriter();
        expectLastCall().andReturn(testParams.printWriterMock).once();
    }
}