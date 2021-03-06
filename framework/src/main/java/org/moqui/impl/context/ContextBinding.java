/*
 * This software is in the public domain under CC0 1.0 Universal plus a 
 * Grant of Patent License.
 * 
 * To the extent possible under law, the author(s) have dedicated all
 * copyright and related and neighboring rights to this software to the
 * public domain worldwide. This software is distributed without any
 * warranty.
 * 
 * You should have received a copy of the CC0 Public Domain Dedication
 * along with this software (see the LICENSE.md file). If not, see
 * <http://creativecommons.org/publicdomain/zero/1.0/>.
 */
package org.moqui.impl.context;

import groovy.lang.Binding;

import java.util.Map;

public class ContextBinding extends Binding {
    public ContextBinding(Map variables) { super(variables); }

    @Override
    public Object getVariable(String name) {
        // NOTE: this code is part of the original Groovy groovy.lang.Binding.getVariable() method and leaving it out
        //     is the reason to override this method:
        //if (result == null && !variables.containsKey(name)) {
        //    throw new MissingPropertyException(name, this.getClass());
        //}
        return getVariables().get(name);
    }

    @Override
    public boolean hasVariable(String name) {
        // always treat it like the variable exists and is null to change the behavior for variable scope and
        //     declaration, easier in simple scripts
        return true;
    }
}
