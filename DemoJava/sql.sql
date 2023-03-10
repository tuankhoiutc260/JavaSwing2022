use master
go
create database DEMO_JAVA_2022
go 
use[DEMO_JAVA_2022]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 5/27/2022 10:43:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[UserName] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](50) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DiaDiemTiem]    Script Date: 5/27/2022 10:43:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DiaDiemTiem](
	[MaDD] [nvarchar](10) NOT NULL,
	[TenDD] [nvarchar](100) NOT NULL,
	[MaVaccine] [nvarchar](10) NOT NULL,
	[MaTP] [nvarchar](10) NULL,
	[MaQuan] [nvarchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Quan]    Script Date: 5/27/2022 10:43:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Quan](
	[MaQuan] [nvarchar](10) NOT NULL,
	[TenQuan] [nvarchar](100) NOT NULL,
	[MaTP] [nvarchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaQuan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThanhPho]    Script Date: 5/27/2022 10:43:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThanhPho](
	[MaTP] [nvarchar](10) NOT NULL,
	[TenTP] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaTP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThongTinCaNhan]    Script Date: 5/27/2022 10:43:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThongTinCaNhan](
	[MaDangKy] [int] IDENTITY(1,1) NOT NULL,
	[HoTen] [nvarchar](100) NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[GioiTinh] [int] NOT NULL,
	[SDT] [nvarchar](15) NOT NULL,
	[CCCD] [nvarchar](100) NOT NULL,
	[SoTheBHYT] [nvarchar](20) NOT NULL,
	[DiaChi] [nvarchar](100) NOT NULL,
	[MaTP] [nvarchar](10) NOT NULL,
	[MaQuan] [nvarchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDangKy] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThongTinDangKyTiem]    Script Date: 5/27/2022 10:43:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThongTinDangKyTiem](
	[MaDangKy] [int] NOT NULL,
	[MaVaccine] [nvarchar](10) NULL,
	[NgayTiem] [date] NOT NULL,
	[MaDD] [nvarchar](10) NOT NULL,
	[TrangThaiDangKy] [nvarchar](100) NULL,
	[TrangThaiTiem] [nvarchar](100) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThongTinTiemChung]    Script Date: 5/27/2022 10:43:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThongTinTiemChung](
	[MaDangKy] [int] NOT NULL,
	[MaVaccine] [nvarchar](10) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Vaccine]    Script Date: 5/27/2022 10:43:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vaccine](
	[MaVaccine] [nvarchar](10) NOT NULL,
	[TenVaccine] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaVaccine] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Account] ([UserName], [Password]) VALUES (N'Admin', N'Admin')
GO
INSERT [dbo].[DiaDiemTiem] ([MaDD], [TenDD], [MaVaccine], [MaTP], [MaQuan]) VALUES (N'33', N'3', N'VC1', N'HCM', N'Q1')
INSERT [dbo].[DiaDiemTiem] ([MaDD], [TenDD], [MaVaccine], [MaTP], [MaQuan]) VALUES (N'K1', N'UBND Lệ Thủy', N'VC5', N'QB', N'LT')
INSERT [dbo].[DiaDiemTiem] ([MaDD], [TenDD], [MaVaccine], [MaTP], [MaQuan]) VALUES (N'K2', N'Quận 2', N'VC3', N'HCM', N'Q2')
INSERT [dbo].[DiaDiemTiem] ([MaDD], [TenDD], [MaVaccine], [MaTP], [MaQuan]) VALUES (N'K3', N'UBND', N'VC4', N'HCM', N'Q1')
INSERT [dbo].[DiaDiemTiem] ([MaDD], [TenDD], [MaVaccine], [MaTP], [MaQuan]) VALUES (N'K4', N'Bệnh viện Thủ Đức', N'VC2', N'HCM', N'TPTD')
INSERT [dbo].[DiaDiemTiem] ([MaDD], [TenDD], [MaVaccine], [MaTP], [MaQuan]) VALUES (N'K5', N'Bệnh viện CuBa', N'VC4', N'QB', N'ĐH')
INSERT [dbo].[DiaDiemTiem] ([MaDD], [TenDD], [MaVaccine], [MaTP], [MaQuan]) VALUES (N'K6', N'Bệnh viện Hà Nội', N'VC2', N'HN', N'HT')
GO
INSERT [dbo].[Quan] ([MaQuan], [TenQuan], [MaTP]) VALUES (N'ĐH', N'Đồng Hới', N'QB')
INSERT [dbo].[Quan] ([MaQuan], [TenQuan], [MaTP]) VALUES (N'HT', N'Hồ Tây', N'HN')
INSERT [dbo].[Quan] ([MaQuan], [TenQuan], [MaTP]) VALUES (N'LT', N'Lệ Thủy', N'QB')
INSERT [dbo].[Quan] ([MaQuan], [TenQuan], [MaTP]) VALUES (N'Q1', N'Quận 1', N'HCM')
INSERT [dbo].[Quan] ([MaQuan], [TenQuan], [MaTP]) VALUES (N'Q2', N'Quận 2', N'HCM')
INSERT [dbo].[Quan] ([MaQuan], [TenQuan], [MaTP]) VALUES (N'Q3', N'Quận 3', N'HCM')
INSERT [dbo].[Quan] ([MaQuan], [TenQuan], [MaTP]) VALUES (N'Q4', N'Quận 4', N'HCM')
INSERT [dbo].[Quan] ([MaQuan], [TenQuan], [MaTP]) VALUES (N'TPTD', N'Thành phố Thủ Đức', N'HCM')
GO
INSERT [dbo].[ThanhPho] ([MaTP], [TenTP]) VALUES (N'ê', N'e')
INSERT [dbo].[ThanhPho] ([MaTP], [TenTP]) VALUES (N'HCM', N'Thành phố Hồ Chí Minh')
INSERT [dbo].[ThanhPho] ([MaTP], [TenTP]) VALUES (N'HN', N'Hà Nội')
INSERT [dbo].[ThanhPho] ([MaTP], [TenTP]) VALUES (N'HUE', N'Huế1')
INSERT [dbo].[ThanhPho] ([MaTP], [TenTP]) VALUES (N'QB', N'Quảng Bình')
GO
SET IDENTITY_INSERT [dbo].[ThongTinCaNhan] ON 

INSERT [dbo].[ThongTinCaNhan] ([MaDangKy], [HoTen], [NgaySinh], [GioiTinh], [SDT], [CCCD], [SoTheBHYT], [DiaChi], [MaTP], [MaQuan]) VALUES (1, N'Nguyễn Tuấn Khôi', CAST(N'2001-10-05' AS Date), 0, N'0385257848', N'251287370', N'SV123456789', N'448 Lê Văn Việt', N'HCM', N'Q1')
INSERT [dbo].[ThongTinCaNhan] ([MaDangKy], [HoTen], [NgaySinh], [GioiTinh], [SDT], [CCCD], [SoTheBHYT], [DiaChi], [MaTP], [MaQuan]) VALUES (2, N'Nguyễn Thanh Dương', CAST(N'2001-03-09' AS Date), 0, N'0976155508', N'123456789', N'SV987654321', N'', N'HCM', N'Q2')
INSERT [dbo].[ThongTinCaNhan] ([MaDangKy], [HoTen], [NgaySinh], [GioiTinh], [SDT], [CCCD], [SoTheBHYT], [DiaChi], [MaTP], [MaQuan]) VALUES (3, N'Trương Tấn Hoàn', CAST(N'2002-02-09' AS Date), 0, N'123456789', N'123456789', N'123456789', N'Quận 3, Thành Phố Hồ Chì Minh', N'HCM', N'Q3')
INSERT [dbo].[ThongTinCaNhan] ([MaDangKy], [HoTen], [NgaySinh], [GioiTinh], [SDT], [CCCD], [SoTheBHYT], [DiaChi], [MaTP], [MaQuan]) VALUES (4, N'Nguyễn Thanh Tùng', CAST(N'2001-05-09' AS Date), 0, N'0865123489', N'987654321', N'987654321', N'', N'HCM', N'Q4')
INSERT [dbo].[ThongTinCaNhan] ([MaDangKy], [HoTen], [NgaySinh], [GioiTinh], [SDT], [CCCD], [SoTheBHYT], [DiaChi], [MaTP], [MaQuan]) VALUES (5, N'Trần Thị B', CAST(N'2003-05-14' AS Date), 1, N'0322198456', N'654987321', N'Sv654987123', N'Đồng Hới - Quảng Bình', N'QB', N'ĐH')
INSERT [dbo].[ThongTinCaNhan] ([MaDangKy], [HoTen], [NgaySinh], [GioiTinh], [SDT], [CCCD], [SoTheBHYT], [DiaChi], [MaTP], [MaQuan]) VALUES (6, N'ABC', CAST(N'2022-05-14' AS Date), 1, N'123', N'1234', N'123', N'ád', N'HCM', N'Q1')
INSERT [dbo].[ThongTinCaNhan] ([MaDangKy], [HoTen], [NgaySinh], [GioiTinh], [SDT], [CCCD], [SoTheBHYT], [DiaChi], [MaTP], [MaQuan]) VALUES (7, N'SA', CAST(N'2022-05-05' AS Date), 0, N'231321', N'21321', N'3213', N'VN', N'HCM', N'Q1')
INSERT [dbo].[ThongTinCaNhan] ([MaDangKy], [HoTen], [NgaySinh], [GioiTinh], [SDT], [CCCD], [SoTheBHYT], [DiaChi], [MaTP], [MaQuan]) VALUES (8, N'Nguyễn Văn A', CAST(N'2006-05-09' AS Date), 0, N'031256478', N'4569876532', N'4897651123', N'Lệ Thủy - Quảng Bình', N'QB', N'LT')
INSERT [dbo].[ThongTinCaNhan] ([MaDangKy], [HoTen], [NgaySinh], [GioiTinh], [SDT], [CCCD], [SoTheBHYT], [DiaChi], [MaTP], [MaQuan]) VALUES (9, N'ád', CAST(N'2001-05-04' AS Date), 1, N'0123456789', N'123', N'sv123456789', N'xc', N'HN', N'HT')
SET IDENTITY_INSERT [dbo].[ThongTinCaNhan] OFF
GO
INSERT [dbo].[ThongTinDangKyTiem] ([MaDangKy], [MaVaccine], [NgayTiem], [MaDD], [TrangThaiDangKy], [TrangThaiTiem]) VALUES (1, N'VC1', CAST(N'2022-05-28' AS Date), N'33', NULL, NULL)
INSERT [dbo].[ThongTinDangKyTiem] ([MaDangKy], [MaVaccine], [NgayTiem], [MaDD], [TrangThaiDangKy], [TrangThaiTiem]) VALUES (2, N'VC1', CAST(N'2022-05-30' AS Date), N'K2', NULL, NULL)
INSERT [dbo].[ThongTinDangKyTiem] ([MaDangKy], [MaVaccine], [NgayTiem], [MaDD], [TrangThaiDangKy], [TrangThaiTiem]) VALUES (3, N'VC3', CAST(N'2022-05-31' AS Date), N'K2', NULL, NULL)
INSERT [dbo].[ThongTinDangKyTiem] ([MaDangKy], [MaVaccine], [NgayTiem], [MaDD], [TrangThaiDangKy], [TrangThaiTiem]) VALUES (4, N'VC1', CAST(N'2022-05-31' AS Date), N'K3', NULL, NULL)
INSERT [dbo].[ThongTinDangKyTiem] ([MaDangKy], [MaVaccine], [NgayTiem], [MaDD], [TrangThaiDangKy], [TrangThaiTiem]) VALUES (5, N'VC2', CAST(N'2022-06-01' AS Date), N'K4', NULL, NULL)
INSERT [dbo].[ThongTinDangKyTiem] ([MaDangKy], [MaVaccine], [NgayTiem], [MaDD], [TrangThaiDangKy], [TrangThaiTiem]) VALUES (6, N'VC3', CAST(N'2022-05-28' AS Date), N'K3', NULL, NULL)
INSERT [dbo].[ThongTinDangKyTiem] ([MaDangKy], [MaVaccine], [NgayTiem], [MaDD], [TrangThaiDangKy], [TrangThaiTiem]) VALUES (7, N'VC3', CAST(N'2022-05-29' AS Date), N'K6', NULL, NULL)
INSERT [dbo].[ThongTinDangKyTiem] ([MaDangKy], [MaVaccine], [NgayTiem], [MaDD], [TrangThaiDangKy], [TrangThaiTiem]) VALUES (8, N'VC2', CAST(N'2022-05-28' AS Date), N'K5', NULL, NULL)
INSERT [dbo].[ThongTinDangKyTiem] ([MaDangKy], [MaVaccine], [NgayTiem], [MaDD], [TrangThaiDangKy], [TrangThaiTiem]) VALUES (9, N'VC3', CAST(N'2022-05-28' AS Date), N'K3', NULL, NULL)
GO
INSERT [dbo].[Vaccine] ([MaVaccine], [TenVaccine]) VALUES (N'VC1', N'Pfizer')
INSERT [dbo].[Vaccine] ([MaVaccine], [TenVaccine]) VALUES (N'VC2', N'Moderna')
INSERT [dbo].[Vaccine] ([MaVaccine], [TenVaccine]) VALUES (N'VC3', N'Johnson & Johnson')
INSERT [dbo].[Vaccine] ([MaVaccine], [TenVaccine]) VALUES (N'VC4', N'AstraZeneca')
INSERT [dbo].[Vaccine] ([MaVaccine], [TenVaccine]) VALUES (N'VC5', N'Sinopharm')
GO
ALTER TABLE [dbo].[DiaDiemTiem]  WITH CHECK ADD FOREIGN KEY([MaVaccine])
REFERENCES [dbo].[Vaccine] ([MaVaccine])
GO
ALTER TABLE [dbo].[DiaDiemTiem]  WITH CHECK ADD FOREIGN KEY([MaQuan])
REFERENCES [dbo].[Quan] ([MaQuan])
GO
ALTER TABLE [dbo].[DiaDiemTiem]  WITH CHECK ADD FOREIGN KEY([MaTP])
REFERENCES [dbo].[ThanhPho] ([MaTP])
GO
ALTER TABLE [dbo].[Quan]  WITH CHECK ADD FOREIGN KEY([MaTP])
REFERENCES [dbo].[ThanhPho] ([MaTP])
GO
ALTER TABLE [dbo].[ThongTinCaNhan]  WITH CHECK ADD FOREIGN KEY([MaTP])
REFERENCES [dbo].[ThanhPho] ([MaTP])
GO
ALTER TABLE [dbo].[ThongTinCaNhan]  WITH CHECK ADD FOREIGN KEY([MaQuan])
REFERENCES [dbo].[Quan] ([MaQuan])
GO
ALTER TABLE [dbo].[ThongTinDangKyTiem]  WITH CHECK ADD FOREIGN KEY([MaVaccine])
REFERENCES [dbo].[Vaccine] ([MaVaccine])
GO
ALTER TABLE [dbo].[ThongTinDangKyTiem]  WITH CHECK ADD FOREIGN KEY([MaDangKy])
REFERENCES [dbo].[ThongTinCaNhan] ([MaDangKy])
GO
ALTER TABLE [dbo].[ThongTinDangKyTiem]  WITH CHECK ADD FOREIGN KEY([MaDD])
REFERENCES [dbo].[DiaDiemTiem] ([MaDD])
GO
ALTER TABLE [dbo].[ThongTinTiemChung]  WITH CHECK ADD FOREIGN KEY([MaDangKy])
REFERENCES [dbo].[ThongTinCaNhan] ([MaDangKy])
GO
ALTER TABLE [dbo].[ThongTinTiemChung]  WITH CHECK ADD FOREIGN KEY([MaVaccine])
REFERENCES [dbo].[Vaccine] ([MaVaccine])
GO
