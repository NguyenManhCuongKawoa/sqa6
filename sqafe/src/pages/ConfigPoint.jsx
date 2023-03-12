import { FormControl, Input, InputLabel, NativeSelect } from '@mui/material'
import React, { useState } from 'react'

const ConfigPoint = () => {
    
    const[monHocId, setMonHocId] = useState(null)
    const[point1, setPoint1] = useState(null)
    const[point2, setPoint2] = useState(null)
    const[point3, setPoint3] = useState(null)

    const handleChangeMonHocId = (e) => {
        console.log(e.target.value);
        setMonHocId(e.target.value)
    }

    const handleChangePoint1 = (e) => {
        console.log(e.target.value);
        setPoint1(e.target.value)
    }

    const handleChangePoint2 = (e) => {
        console.log(e.target.value);
        setPoint2(e.target.value)
    }

    const handleChangePoint3 = (e) => {
        console.log(e.target.value);
        setPoint3(e.target.value)
    }

  return (
    <div className="container">
        <h4 className="page-header">Chọn môn học cần cấu hình hệ số điểm</h4>
        <div className="row">
            <div className="col-sm-3">
                <FormControl>
                    <NativeSelect
                        value={monHocId}
                        onChange={handleChangeMonHocId}
                        input={<Input name="age" id="age-native-label-placeholder" />}
                    >
                        <option value={""}>Choose...</option>
                        <option value="0.1">0.1</option>
                    </NativeSelect>
                </FormControl>
            </div>
        </div>
        <br />
        <div className={monHocId == null || monHocId == "" ? "d-none" : ""}>
            <div className="d-flex align-items-center mb-4">
                <div className="mr-4">Điểm Điểm Danh</div>
                <FormControl>
                    <NativeSelect
                        value={point1}
                        onChange={handleChangePoint1}
                        input={<Input name="age" id="age-native-label-placeholder" />}
                    >
                        <option value={null}>Choose...</option>
                        <option value="0.1">0.1</option>
                        <option value="0.2">0.2</option>
                        <option value="0.3">0.3</option>
                        <option value="0.4">0.4</option>
                        <option value="0.5">0.5</option>
                        <option value="0.6">0.6</option>
                        <option value="0.7">0.7</option>
                        <option value="0.8">0.8</option>
                        <option value="0.9">0.9</option>
                        <option value="1.0">1.0</option>
                    </NativeSelect>
                </FormControl>
            </div>
            <div className="d-flex align-items-center mb-4">
                <div className="mr-4">Điểm Kiểm Tra</div>
                <FormControl>
                    <NativeSelect
                        value={point2}
                        onChange={handleChangePoint1}
                        input={<Input name="age" id="age-native-label-placeholder" />}
                    >
                        <option value={null}>Choose...</option>
                        <option value="0.1">0.1</option>
                        <option value="0.2">0.2</option>
                        <option value="0.3">0.3</option>
                        <option value="0.4">0.4</option>
                        <option value="0.5">0.5</option>
                        <option value="0.6">0.6</option>
                        <option value="0.7">0.7</option>
                        <option value="0.8">0.8</option>
                        <option value="0.9">0.9</option>
                        <option value="1.0">1.0</option>
                    </NativeSelect>
                </FormControl>
            </div>
            <div className="d-flex align-items-center mb-4">
                <div className="mr-4">Điểm Thi Cuối Kì</div>
                <FormControl>
                    <NativeSelect
                        value={point3}
                        onChange={handleChangePoint3}
                        input={<Input name="age" id="age-native-label-placeholder" />}
                    >
                        <option value={null}>Choose...</option>
                        <option value="0.1">0.1</option>
                        <option value="0.2">0.2</option>
                        <option value="0.3">0.3</option>
                        <option value="0.4">0.4</option>
                        <option value="0.5">0.5</option>
                        <option value="0.6">0.6</option>
                        <option value="0.7">0.7</option>
                        <option value="0.8">0.8</option>
                        <option value="0.9">0.9</option>
                        <option value="1.0">1.0</option>
                    </NativeSelect>
                </FormControl>
            </div>
            <button type="button" className="btn btn-primary">Lưu</button>
        </div>
    </div>
  )
}

export default ConfigPoint