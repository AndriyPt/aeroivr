/*
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

#include <jni.h>
#include "OpenH323JavaObject.h"

/*
#include "OpenH323JNIApplication.h"

OpenH323JNIApplication * g_H323Application;

JNIEXPORT void JNICALL Java_org_aeroivr_appserver_h323_OpenH323_init 
  (JNIEnv * envinronment, jobject object)
{
	g_H323Application = new OpenH323JNIApplication();
    try
    {
        if (!g_H323Application->GetH323EndPoint()->Initialise())
        {
			return JNI_FALSE;
        }

		JavaVM * jvm;
		jobject thisObject;

        envinronment->GetJavaVM(&jvm);
        thisObject = env->NewGlobalRef(obj);
        if (NULL == thisObject) 
        {
			return JNI_FALSE;
        }

		OpenH323JavaObject::SetJvmAndThisPointers(jvm, thisObject);
    }
    catch(...)
    {
            PTRACE(TRACE_ERROR, "Catch exception in init native method");
            return JNI_FALSE;
    }
    return JNI_TRUE;
}

JNIEXPORT void JNICALL Java_org_aeroivr_appserver_h323_OpenH323_startListening
  (JNIEnv * envinronment, jobject object)
{
    if (NULL != g_H323Application) 
    {
        if(!g_H323Application->GetH323EndPoint()->StartListener("*"))
        {
            PTRACE(TRACE_ERROR, "Could not open H.323 listener ");
            return JNI_FALSE;
        }
    }
    else 
    {
        return JNI_FALSE;
    }
    return JNI_TRUE;
}

JNIEXPORT void JNICALL Java_org_aeroivr_appserver_h323_OpenH323_shutdown
  (JNIEnv * envinronment, jobject object)
{
    if (NULL != g_H323Application)
    {
        delete g_H323Application;
        return JNI_TRUE;
    }
    else
    {
        return JNI_FALSE;
    }
}
*/
