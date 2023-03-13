import { FormControl, Input, InputLabel, NativeSelect } from '@mui/material'
import clsx from 'clsx'
import React, { useEffect, useState } from 'react'
import { toast } from 'react-toastify'
import { configPoints, fixPoints, getConfigPoints, getSubjects } from '../service/apiservice'

const ConfigPoint = () => {
    const[subjects, setSubjects] = useState(null)
    const[percents, setPercents] = useState(null)
    const[monHocId, setMonHocId] = useState("")
    const[point1, setPoint1] = useState("")
    const[point2, setPoint2] = useState("")
    const[point3, setPoint3] = useState("")

    useEffect(() => {
        getSubjects()
            .then(res => {
                console.log(res.data.content);
                setSubjects(res.data.content)
            })
            .catch(error => toast.error("Có lỗi xảy ra khi lấy dữ liệu"));
    }, [])
    

    const handleChangeMonHocId = (e) => {
        console.log(e.target.value);
        setMonHocId(e.target.value)
        getConfigPoints(e.target.value)
            .then(res => {
                setPercents(res.data)
                if(res.data == null || res.data.length == 0) {
                    setPoint1("")
                    setPoint2("")
                    setPoint3("")
                } else {
                    
                    console.log(res.data);
                    setPoint1(res.data[0].phanTram)
                    setPoint2(res.data[1].phanTram)
                    setPoint3(res.data[2].phanTram)
                }
            })
            .catch(error => {
                console.log(error);
                toast.error("Có lỗi xảy ra khi lấy dữ liệu")
            });
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


    const handleSave = () => {
        if(point1 == "" || point2 == "" || point3 == "") return
        if(percents != null && percents.length != 0 && point1 == percents[0].phanTram && point2 == percents[1].phanTram && point3 == percents[2].phanTram) return
        // console.log(Number(point1) + Number(point2) + Number(point3));
        if(Number(point1) + Number(point2) + Number(point3) == 1) {
            if(percents == null || percents.length == 0) {
                let data = [
                    {
                        "dauDiemId": 1,
                        "phanTram": Number(point1)
                    },
                    {
                        "dauDiemId": 2,
                        "phanTram": Number(point2)
                    },
                    {
                        "dauDiemId": 3,
                        "phanTram": Number(point3)
                    }
                ]
                console.log(data);
                configPoints(monHocId, data)
                    .then(res => {
                        console.log(res);
                        setPercents(data)
                        toast.info("Lưu đầu điểm thành công!")
                    })
                    .catch(error => toast.error("Có lỗi xảy ra khi lưu dữ liệu"));
            } else {
                let data = [Number(point1), Number(point2), Number(point3)]
                fixPoints(monHocId, data)
                    .then(res => {
                        setPercents(pre => {
                            pre = [
                                {
                                    "dauDiemId": 1,
                                    "phanTram": Number(point1)
                                },
                                {
                                    "dauDiemId": 2,
                                    "phanTram": Number(point2)
                                },
                                {
                                    "dauDiemId": 3,
                                    "phanTram": Number(point3)
                                }
                            ]
                            console.log(pre);
                            return pre
                        })
                        toast.info("Cập nhật đầu điểm thành công!")
                    })
                    .catch(error => toast.error("Có lỗi xảy ra khi cập nhật dữ liệu"));
            }
            
        } else {
            toast.warn("Tổng hệ số phải bằng 1")
        }
    }

    const handleReset = () => {
        if(percents == null || percents.length == 0) {
            setPoint1("")
            setPoint2("")
            setPoint3("")
        } else {
            setPoint1(percents[0].phanTram)
            setPoint2(percents[1].phanTram)
            setPoint3(percents[2].phanTram)
        }
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
                    >
                        
                        <option value={""}>Choose...</option>
                        {
                            subjects != null ? subjects.map((s, i) => {
                                return <option value={s.id} key={i}>{s.name}</option>
                            }) : ""
                        }
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
                    >
                        <option value={""}>Choose...</option>
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
                        onChange={handleChangePoint2}
                    >
                        <option value={""}>Choose...</option>
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
                        <option value={""}>Choose...</option>
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
            <div className="d-flex gap-4">
                <button type="button" className={clsx("btn btn-primary mr-4", {
                    disabled: ((percents == null || percents.length == 0) && (point1 == "" || point2 == "" || point3 == "")) 
                    || (percents != null && percents.length != 0 && (point1 == percents[0].phanTram && point2 == percents[1].phanTram && point3 == percents[2].phanTram))
                })} onClick={handleSave}>{percents == null || percents.length == 0 ? "Lưu" : "Cập Nhật"}</button>
                <button type="button" onClick={handleReset} className={clsx("btn btn-primary", {
                    disabled: ((percents == null || percents.length == 0) && (point1 == "" && point2 == "" && point3 == "")) 
                 || (percents != null && percents.length != 0 && (point1 == percents[0].phanTram && point2 == percents[1].phanTram && point3 == percents[2].phanTram))
                })}>Reset</button>
            </div>
        </div>
    </div>
  )
}

export default ConfigPoint