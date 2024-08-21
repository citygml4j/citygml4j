/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.model.gml.coverage;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.valueObjects.ScalarValueList;
import org.citygml4j.model.gml.valueObjects.ValueArray;

import java.util.List;

public class RangeSet implements GML, Child, Copyable {
    private List<ValueArray> valueArray;
    private List<ScalarValueList> scalarValueList;
    private DataBlock dataBlock;
    private File file;
    private ModelObject parent;

    public RangeSet() {

    }

    public RangeSet(ValueArray valueArray) {
        addValueArray(valueArray);
    }

    public RangeSet(ScalarValueList scalarValueList) {
        addScalarValueList(scalarValueList);
    }

    public RangeSet(DataBlock dataBlock) {
        setDataBlock(dataBlock);
    }

    public RangeSet(File file) {
        setFile(file);
    }

    public GMLClass getGMLClass() {
        return GMLClass.RANGE_SET;
    }

    public void addValueArray(ValueArray valueArray) {
        getValueArray().add(valueArray);
        unsetDataBlock();
        unsetFile();
        unsetScalarValueList();
    }

    public List<ValueArray> getValueArray() {
        if (valueArray == null)
            valueArray = new ChildList<>(this);

        return valueArray;
    }

    public void addScalarValueList(ScalarValueList scalarValueList) {
        getScalarValueList().add(scalarValueList);
        unsetDataBlock();
        unsetFile();
        unsetValueArray();
    }

    public List<ScalarValueList> getScalarValueList() {
        if (scalarValueList == null)
            scalarValueList = new ChildList<>(this);

        return scalarValueList;
    }

    public DataBlock getDataBlock() {
        return dataBlock;
    }

    public File getFile() {
        return file;
    }

    public boolean isSetValueArray() {
        return valueArray != null && !valueArray.isEmpty();
    }

    public boolean isSetScalarValueList() {
        return scalarValueList != null && !scalarValueList.isEmpty();
    }

    public boolean isSetDataBlock() {
        return dataBlock != null;
    }

    public boolean isSetFile() {
        return file != null;
    }

    public void setValueArray(List<ValueArray> valueArray) {
        this.valueArray = new ChildList<>(this, valueArray);
        unsetDataBlock();
        unsetFile();
        unsetScalarValueList();
    }

    public void setScalarValueList(List<ScalarValueList> scalarValueList) {
        this.scalarValueList = new ChildList<>(this, scalarValueList);
        unsetDataBlock();
        unsetFile();
        unsetValueArray();
    }

    public void setDataBlock(DataBlock dataBlock) {
        this.dataBlock = ModelObjects.setParent(dataBlock, this);
        unsetFile();
        unsetScalarValueList();
        unsetValueArray();
    }

    public void setFile(File file) {
        this.file = ModelObjects.setParent(file, this);
        unsetDataBlock();
        unsetScalarValueList();
        unsetValueArray();
    }

    public boolean unsetValueArray(ValueArray valueArray) {
        return isSetValueArray() && this.valueArray.remove(valueArray);
    }

    public void unsetValueArray() {
        valueArray = ModelObjects.setNull(valueArray);
    }

    public boolean unsetScalarValueList(ScalarValueList scalarValueList) {
        return isSetScalarValueList() && this.scalarValueList.remove(scalarValueList);
    }

    public void unsetScalarValueList() {
        scalarValueList = ModelObjects.setNull(scalarValueList);
    }

    public void unsetDataBlock() {
        dataBlock = ModelObjects.setNull(dataBlock);
    }

    public void unsetFile() {
        file = ModelObjects.setNull(file);
    }

    public ModelObject getParent() {
        return parent;
    }

    public void setParent(ModelObject parent) {
        this.parent = parent;
    }

    public boolean isSetParent() {
        return parent != null;
    }

    public void unsetParent() {
        parent = null;
    }

    public Object copyTo(Object target, CopyBuilder copyBuilder) {
        RangeSet copy = (target == null) ? new RangeSet() : (RangeSet) target;

        if (isSetDataBlock()) {
            copy.setDataBlock((DataBlock) copyBuilder.copy(dataBlock));
            if (copy.getDataBlock() == dataBlock)
                dataBlock.setParent(this);
        }

        if (isSetScalarValueList()) {
            for (ScalarValueList part : scalarValueList) {
                ScalarValueList copyPart = (ScalarValueList) copyBuilder.copy(part);
                copy.addScalarValueList(copyPart);

                if (part != null && copyPart == part)
                    part.setParent(this);
            }
        }

        if (isSetFile()) {
            copy.setFile((File) copyBuilder.copy(file));
            if (copy.getFile() == file)
                file.setParent(this);
        }

        if (isSetValueArray()) {
            for (ValueArray part : valueArray) {
                ValueArray copyPart = (ValueArray) copyBuilder.copy(part);
                copy.addValueArray(copyPart);

                if (part != null && copyPart == part)
                    part.setParent(this);
            }
        }

        copy.unsetParent();

        return copy;
    }

    public Object copy(CopyBuilder copyBuilder) {
        return copyTo(new RangeSet(), copyBuilder);
    }

}
