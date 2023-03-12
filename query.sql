
/* ----------- School ----------- */
insert into sqa6.truong (id, name, address) values(1, 'PTIT', '122 Hoàng Quốc Việt, Cổ Nhuế, Cầu Giấy, Hà Nội');

/* ----------- Khoa ----------- */
insert into sqa6.khoa (id, name, des, truong_id) values(1, 'Công nghệ thông tin', 'Công nghệ thông tin', 1);
insert into sqa6.khoa (id, name, des, truong_id) values(2, 'An toàn thông tin', 'An toàn thông tin', 1);
insert into sqa6.khoa (id, name, des, truong_id) values(3, 'Kinh tế', 'Kinh tế', 1);

/* ----------- Bộ môn ----------- */
insert into sqa6.bo_mon (id, name, des, khoa_id) values(1, 'Lập trình java', 'Lập trình java', 1);
insert into sqa6.bo_mon (id, name, des, khoa_id) values(2, 'Đảm bảo chất lượng phầm mềm', 'Đảm bảo chất lượng phầm mềm', 1);
insert into sqa6.bo_mon (id, name, des, khoa_id) values(3, 'Quản trị kinh doanh', 'Quản trị kinh doanh', 3);
insert into sqa6.bo_mon (id, name, des, khoa_id) values(4, 'Kế toán', 'Kế toán', 3);

/* ----------- Môn học ----------- */
insert into sqa6.mon_hoc (id, name, des, bo_mon_id) values(1, 'Lập trình java', 'Lập trình java', 1);
insert into sqa6.mon_hoc (id, name, des, bo_mon_id) values(2, 'Đảm bảo chất lượng phầm mềm', 'Đảm bảo chất lượng phầm mềm', 1);
insert into sqa6.mon_hoc (id, name, des, bo_mon_id) values(3, 'Quản trị kinh doanh', 'Quản trị kinh doanh', 4);

/* ----------- Đầu điểm ----------- */
insert into sqa6.dau_diem (id, name, mota) values(1, 'Điểm điểm danh', 'DIEM_DIEM_DANH');
insert into sqa6.dau_diem (id, name, mota) values(2, 'Điểm kiểm tra giữa kì', 'DIEM_KIEM_TRA_GIUA_KI');
insert into sqa6.dau_diem (id, name, mota) values(3, 'Điểm kiểm tra cuối kì', 'DIEM_KIEM_TRA_CUOI_KI');
insert into sqa6.dau_diem (id, name, mota) values(4, 'Điểm tổng kết', 'DIEM_TONG_KETuser');

/* ----------- Lịch học ----------- */
insert into sqa6.lich (id, name, address, start, end, gv_id, monhoc_id) values(1, 'Lịch học 1', 'Phòng 302 A2', '2022-11-22 09:00:00', '2022-11-22 11:00:00', 1, 1);
insert into sqa6.lich (id, name, address, start, end, gv_id, monhoc_id) values(2, 'Lịch học 2', 'Phòng 606 A2', '2022-11-22 07:00:00', '2022-11-22 09:00:00', 1, 2);
insert into sqa6.lich (id, name, address, start, end, gv_id, monhoc_id) values(3, 'Lịch học 3', 'Phòng 202 A3', '2022-11-22 09:00:00', '2022-11-22 11:00:00', 2, 1);

insert into sqa6.lich_sv (id, sv_id, lich_id) values(1, 3, 1);
insert into sqa6.lich_sv (id, sv_id, lich_id) values(2, 3, 2);











