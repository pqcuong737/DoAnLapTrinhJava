USE [master]
GO
/****** Object:  Database [QuanLyKhachSan]    Script Date: 24/04/2020 18:58:27 ******/
CREATE DATABASE [QuanLyKhachSan]
GO
ALTER DATABASE [QuanLyKhachSan] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyKhachSan].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyKhachSan] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyKhachSan] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyKhachSan] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyKhachSan] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QuanLyKhachSan] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyKhachSan] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLyKhachSan] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyKhachSan] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyKhachSan] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyKhachSan] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [QuanLyKhachSan]
GO
/****** Object:  Table [dbo].[ChiTietDichVu]    Script Date: 24/04/2020 18:58:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietDichVu](
	[MaCTDV] [int] IDENTITY(1,1) NOT NULL,
	[MaDatPhong] [int] NOT NULL,
	[MaDichVu] [nvarchar](50) NOT NULL,
	[DonGia] [money] NOT NULL,
	[SoLuong] [float] NOT NULL CONSTRAINT [DF_ChiTietDichVu_SoLuong]  DEFAULT ((1)),
	[ThanhTien] [money] NULL,
 CONSTRAINT [PK_ChiTietDichVu] PRIMARY KEY CLUSTERED 
(
	[MaCTDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ChiTietLuong]    Script Date: 24/04/2020 18:58:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietLuong](
	[MaChiTietLuong] [nvarchar](50) NOT NULL,
	[MaNhanVien] [nvarchar](50) NULL,
	[SoNgayNghi] [int] NULL,
	[SoNgayLam] [int] NULL,
	[NgayNhanLuong] [date] NULL,
	[TongNhan] [money] NULL,
 CONSTRAINT [PK_NhanLuong] PRIMARY KEY CLUSTERED 
(
	[MaChiTietLuong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DatPhong]    Script Date: 24/04/2020 18:58:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DatPhong](
	[MaDatPhong] [int] IDENTITY(1,1) NOT NULL,
	[MaKhachHang] [nvarchar](50) NOT NULL,
	[MaPhong] [nvarchar](50) NOT NULL,
	[LoaiHinhThue] [bit] NULL,
	[NgayThue] [datetime] NULL CONSTRAINT [DF_DatPhong_NgayThue]  DEFAULT (getdate()),
	[NgayRaDuKien] [datetime] NULL,
	[SoNguoi] [int] NULL CONSTRAINT [DF_DatPhong_SoNguoi]  DEFAULT ((1)),
	[TenUser] [nvarchar](50) NOT NULL,
	[TinhTrang] [nvarchar](50) NULL CONSTRAINT [DF_DatPhong_TinhTrang]  DEFAULT (N'Chưa thanh toán'),
	[TienDatCoc] [money] NULL CONSTRAINT [DF_DatPhong_TienDatCoc]  DEFAULT ((0)),
 CONSTRAINT [PK_DatPhong] PRIMARY KEY CLUSTERED 
(
	[MaDatPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DichVu]    Script Date: 24/04/2020 18:58:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DichVu](
	[MaDichVu] [nvarchar](50) NOT NULL,
	[TenDichVu] [nvarchar](50) NOT NULL,
	[DonVi] [nvarchar](50) NOT NULL,
	[DonGia] [money] NOT NULL,
	[GhiChu] [nvarchar](255) NULL,
 CONSTRAINT [PK_DichVu] PRIMARY KEY CLUSTERED 
(
	[MaDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 24/04/2020 18:58:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHoaDon] [int] IDENTITY(1,1) NOT NULL,
	[MaDatPhong] [int] NOT NULL,
	[TenUser] [nvarchar](50) NOT NULL,
	[TenKhachHang] [nvarchar](50) NOT NULL,
	[MaPhong] [nvarchar](50) NOT NULL,
	[SoNgayThue] [float] NULL,
	[SoGioThue] [float] NULL,
	[TienPhong] [money] NULL,
	[PhuThuCheckin] [money] NULL,
	[PhuThuCheckout] [money] NULL,
	[TienDichVu] [money] NULL,
	[ThanhTien] [money] NOT NULL,
	[NgayThanhToan] [date] NULL,
	[GhiChu] [nvarchar](max) NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Khac]    Script Date: 24/04/2020 18:58:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Khac](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[GiaTriSo] [float] NULL,
	[GiaTriTG] [time](7) NULL,
	[MoTa] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 24/04/2020 18:58:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKhachHang] [nvarchar](50) NOT NULL,
	[MaLoaiKH] [nvarchar](50) NOT NULL,
	[TenKhachHang] [nvarchar](50) NOT NULL,
	[Tuoi] [int] NULL,
	[GioiTinh] [bit] NULL CONSTRAINT [DF_KhachHang_GioiTinh]  DEFAULT ('true'),
	[SoDienThoai] [char](10) NULL CONSTRAINT [DF_KhachHang_SoDienThoai]  DEFAULT (N'0123456789'),
	[SoCMND] [char](12) NULL CONSTRAINT [DF_KhachHang_SoCMND]  DEFAULT (N'123456789111'),
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LoaiKhachHang]    Script Date: 24/04/2020 18:58:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiKhachHang](
	[MaLoaiKH] [nvarchar](50) NOT NULL,
	[TenLoaiKH] [nvarchar](50) NOT NULL,
	[TienGiam] [int] NULL,
	[MoTa] [nvarchar](max) NULL,
 CONSTRAINT [PK_LoaiKhachHang] PRIMARY KEY CLUSTERED 
(
	[MaLoaiKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[LoaiPhong]    Script Date: 24/04/2020 18:58:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiPhong](
	[MaLoaiPhong] [nvarchar](50) NOT NULL,
	[TenLoaiPhong] [nvarchar](50) NOT NULL,
	[GiuongDon] [int] NULL,
	[GiuongDoi] [int] NULL,
	[GiaTheoGio] [money] NULL,
	[GiaTheoNgay] [money] NULL,
 CONSTRAINT [PK_LoaiPhong] PRIMARY KEY CLUSTERED 
(
	[MaLoaiPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Luong]    Script Date: 24/04/2020 18:58:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Luong](
	[MaLuong] [nvarchar](50) NOT NULL,
	[LuongTheoGio] [money] NOT NULL,
	[SoGioLam] [int] NOT NULL,
	[GhiChu] [nvarchar](max) NULL CONSTRAINT [DF_Luong_NgayBatDauLam]  DEFAULT (getdate()),
 CONSTRAINT [PK_Luong] PRIMARY KEY CLUSTERED 
(
	[MaLuong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 24/04/2020 18:58:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNhanVien] [nvarchar](50) NOT NULL,
	[TenNhanVien] [nvarchar](50) NOT NULL,
	[GioiTinh] [bit] NULL CONSTRAINT [DF_NhanVien_GioiTinh]  DEFAULT ('true'),
	[NgaySinh] [date] NULL,
	[SoDienThoai] [char](10) NULL,
	[MaLuong] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](max) NULL,
	[Hinh] [nvarchar](max) NULL,
	[NgayBatDauLam] [date] NULL CONSTRAINT [DF_NhanVien_NgayBatDauLam]  DEFAULT (getdate()),
	[GhiChu] [nvarchar](255) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Phong]    Script Date: 24/04/2020 18:58:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phong](
	[MaPhong] [nvarchar](50) NOT NULL,
	[MaLoaiPhong] [nvarchar](50) NOT NULL,
	[DienTich] [int] NULL,
	[MaTang] [int] NULL CONSTRAINT [DF_Phong_MaTang]  DEFAULT ((1)),
	[GiuongDon] [int] NULL CONSTRAINT [DF_Phong_GiuongDon]  DEFAULT ((0)),
	[GiuongDoi] [int] NULL CONSTRAINT [DF_Phong_GiuongDoi]  DEFAULT ((0)),
	[Hinh] [nvarchar](max) NULL,
	[TinhTrang] [nvarchar](50) NULL CONSTRAINT [DF_Phong_TinhTrang]  DEFAULT (N'trống'),
	[GhiChu] [nvarchar](255) NULL,
 CONSTRAINT [PK_Phong] PRIMARY KEY CLUSTERED 
(
	[MaPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Quyen]    Script Date: 24/04/2020 18:58:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Quyen](
	[MaQuyen] [nvarchar](50) NOT NULL,
	[TenQuyen] [nvarchar](50) NOT NULL,
	[MoTa] [nvarchar](255) NULL,
 CONSTRAINT [PK_Quyen] PRIMARY KEY CLUSTERED 
(
	[MaQuyen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[User]    Script Date: 24/04/2020 18:58:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[TenUser] [nvarchar](50) NOT NULL,
	[MatKhau] [nvarchar](50) NULL,
	[NgayLap] [date] NOT NULL CONSTRAINT [DF_User_NgayLap]  DEFAULT (getdate()),
	[MaQuyen] [nvarchar](50) NOT NULL,
	[GhiChu] [nvarchar](255) NULL,
	[MaNhanVien] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[TenUser] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[ChiTietDichVu] ON 

INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (1, 3, N'dv01', 10000.0000, 1, 10000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (4, 3, N'dv02', 16.0000, 24, 384.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (5, 3, N'dv04', 3000.0000, 5, 15000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (8, 20, N'dv02', 16000.0000, 2, 32000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (10, 20, N'dv03', 1000.0000, 5, 5000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (11, 20, N'dv04', 3000.0000, 30, 90000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (12, 21, N'dv02', 16000.0000, 7, 112000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (13, 21, N'dv07', 2000.0000, 1, 2000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (14, 24, N'dv01', 10000.0000, 4, 40000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (15, 22, N'dv01', 10000.0000, 1, 10000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (16, 22, N'dv02', 16000.0000, 1, 16000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (17, 22, N'dv03', 1000.0000, 1, 1000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (18, 27, N'dv04', 3000.0000, 3, 9000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (19, 27, N'dv02', 16000.0000, 24, 384000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (20, 23, N'dv01', 10000.0000, 3, 30000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (21, 28, N'dv02', 16000.0000, 1, 16000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (22, 23, N'dv06', 2000.0000, 5, 10000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (25, 29, N'dv01', 10000.0000, 4, 40000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (26, 28, N'dv01', 10000.0000, 4, 40000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (27, 29, N'dv02', 16000.0000, 4, 64000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (28, 29, N'dv01', 10000.0000, 1, 10000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (31, 29, N'dv01', 10000.0000, 1, 10000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (32, 31, N'dv02', 16000.0000, 5, 80000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (33, 61, N'dv02', 16000.0000, 24, 384000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (34, 61, N'dv01', 10000.0000, 1, 10000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (35, 67, N'dv02', 16000.0000, 24, 384000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (36, 67, N'dv05', 3000.0000, 30, 90000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (37, 68, N'dv01', 10000.0000, 1, 10000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (38, 72, N'dv01', 10000.0000, 12, 120000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (39, 73, N'dv02', 16000.0000, 1, 16000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (47, 73, N'dv02', 16000.0000, 1, 16000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (1035, 1068, N'dv01', 10000.0000, 4, 40000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (1036, 1068, N'dv010', 50000.0000, 0, 0.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (1041, 1074, N'dv00123', 10000.0000, 5, 50000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (1042, 1074, N'dv02', 16000.0000, 24, 384000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (1043, 1075, N'dv01', 10000.0000, 3, 30000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (1044, 1075, N'dv05', 3000.0000, 1, 3000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (1045, 1073, N'dv00123', 10000.0000, 2, 20000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (1046, 1076, N'dv00123', 10000.0000, 3, 30000.0000)
INSERT [dbo].[ChiTietDichVu] ([MaCTDV], [MaDatPhong], [MaDichVu], [DonGia], [SoLuong], [ThanhTien]) VALUES (1047, 1077, N'dv03', 1000.0000, 1, 1000.0000)
SET IDENTITY_INSERT [dbo].[ChiTietDichVu] OFF
INSERT [dbo].[ChiTietLuong] ([MaChiTietLuong], [MaNhanVien], [SoNgayNghi], [SoNgayLam], [NgayNhanLuong], [TongNhan]) VALUES (N'04122019ád;kfl', N'ád;kfl', 0, 3, CAST(N'2019-12-04' AS Date), 432000.0000)
INSERT [dbo].[ChiTietLuong] ([MaChiTietLuong], [MaNhanVien], [SoNgayNghi], [SoNgayLam], [NgayNhanLuong], [TongNhan]) VALUES (N'06012020fsfsdìa', N'fsfsdìa', 3, 22, CAST(N'2020-01-06' AS Date), 3520000.0000)
INSERT [dbo].[ChiTietLuong] ([MaChiTietLuong], [MaNhanVien], [SoNgayNghi], [SoNgayLam], [NgayNhanLuong], [TongNhan]) VALUES (N'07012020ád;kfl', N'ád;kfl', 0, 402, CAST(N'2020-01-07' AS Date), 57888000.0000)
INSERT [dbo].[ChiTietLuong] ([MaChiTietLuong], [MaNhanVien], [SoNgayNghi], [SoNgayLam], [NgayNhanLuong], [TongNhan]) VALUES (N'12122019fsfsd', N'fsfsd', 0, 8, CAST(N'2019-12-12' AS Date), 1280000.0000)
INSERT [dbo].[ChiTietLuong] ([MaChiTietLuong], [MaNhanVien], [SoNgayNghi], [SoNgayLam], [NgayNhanLuong], [TongNhan]) VALUES (N'12122019fsfsdìa', N'fsfsdìa', 0, 8, CAST(N'2019-12-12' AS Date), 1280000.0000)
INSERT [dbo].[ChiTietLuong] ([MaChiTietLuong], [MaNhanVien], [SoNgayNghi], [SoNgayLam], [NgayNhanLuong], [TongNhan]) VALUES (N'23122019NV006', N'NV006', 2, 20, CAST(N'2019-12-23' AS Date), 3200000.0000)
SET IDENTITY_INSERT [dbo].[DatPhong] ON 

INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (3, N'KH001', N'001', 0, CAST(N'2019-11-08 15:18:31.170' AS DateTime), NULL, 1, N'admin', N'Đã thanh toán', NULL)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (5, N'KH001', N'001', 1, CAST(N'2019-01-01 00:00:00.000' AS DateTime), CAST(N'2019-02-01 00:00:00.000' AS DateTime), 1, N'admin', N'Đã thanh toán', NULL)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (12, N'KH001', N'002', 0, CAST(N'2019-11-08 00:00:00.000' AS DateTime), CAST(N'2019-11-10 00:00:00.000' AS DateTime), 3, N'admin', N'Đã thanh toán', NULL)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (14, N'KH001', N'003', 0, CAST(N'2019-11-13 00:00:00.000' AS DateTime), CAST(N'2019-11-20 00:00:00.000' AS DateTime), 1, N'admin', N'Đã thanh toán', NULL)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (15, N'KH001', N'004', 0, CAST(N'2019-11-13 09:56:39.000' AS DateTime), CAST(N'2019-11-14 00:00:00.000' AS DateTime), 1, N'admin', N'Đã thanh toán', NULL)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (16, N'KH001', N'005', 0, CAST(N'2019-11-13 14:01:28.000' AS DateTime), CAST(N'1900-01-01 00:00:00.000' AS DateTime), 4, N'admin', N'Đã thanh toán', NULL)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (17, N'KH001', N'006', 0, CAST(N'2019-11-16 09:53:24.000' AS DateTime), CAST(N'2019-11-16 00:00:00.000' AS DateTime), 1, N'admin', N'Đã thanh toán', NULL)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (18, N'KH002', N'007', 1, CAST(N'2019-11-16 10:41:59.000' AS DateTime), CAST(N'2019-11-16 00:00:00.000' AS DateTime), 2, N'admin', N'Đã thanh toán', NULL)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (19, N'kh003', N'008', 1, CAST(N'2019-11-16 23:11:07.000' AS DateTime), CAST(N'2019-11-16 00:00:00.000' AS DateTime), 3, N'admin', N'Đã thanh toán', NULL)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (20, N'KH002', N'001', 1, CAST(N'2019-11-17 00:03:15.000' AS DateTime), CAST(N'2019-11-17 00:00:00.000' AS DateTime), 1, N'admin', N'Đã thanh toán', NULL)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (21, N'KH005', N'002', 1, CAST(N'2019-11-17 11:43:58.000' AS DateTime), CAST(N'2019-11-17 00:00:00.000' AS DateTime), 1, N'admin', N'Đã thanh toán', NULL)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (22, N'KH002', N'003', 1, CAST(N'2019-11-17 17:50:45.000' AS DateTime), CAST(N'2019-11-17 17:50:45.000' AS DateTime), 2, N'admin', N'Đã thanh toán', NULL)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (23, N'kh004', N'004', 1, CAST(N'2019-11-17 19:00:41.000' AS DateTime), CAST(N'2019-11-18 19:00:41.000' AS DateTime), 2, N'admin', N'Đã thanh toán', NULL)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (24, N'khmoi', N'006', 0, CAST(N'2019-11-18 08:22:04.000' AS DateTime), CAST(N'2019-11-19 08:22:04.000' AS DateTime), 1, N'admin', N'Đã thanh toán', NULL)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (25, N'KH002', N'005', 1, CAST(N'2019-11-20 00:54:51.000' AS DateTime), CAST(N'2019-11-20 00:54:51.000' AS DateTime), 3, N'admin', N'Đã thanh toán', NULL)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (26, N'KH005', N'001', 1, CAST(N'2019-11-20 07:23:15.000' AS DateTime), CAST(N'2019-11-20 07:23:15.000' AS DateTime), 2, N'admin', N'Đã thanh toán', NULL)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (27, N'KH002', N'007', 1, CAST(N'2019-11-20 07:26:58.000' AS DateTime), CAST(N'2019-11-22 07:26:58.000' AS DateTime), 3, N'admin', N'Đã thanh toán', NULL)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (28, N'kh007', N'008', 1, CAST(N'2019-11-20 07:33:21.000' AS DateTime), CAST(N'2019-11-20 07:33:21.000' AS DateTime), 1, N'admin', N'Đã thanh toán', NULL)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (29, N'kh004', N'009', 1, CAST(N'2019-11-20 07:44:55.000' AS DateTime), CAST(N'2019-11-22 07:44:55.000' AS DateTime), 2, N'admin', N'Đã thanh toán', NULL)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (30, N'KH001sđá', N'002', 1, CAST(N'2019-11-21 15:07:29.000' AS DateTime), CAST(N'2019-11-21 15:07:29.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (31, N'KH005', N'001', 0, CAST(N'2019-11-21 15:21:16.000' AS DateTime), CAST(N'2019-11-22 15:21:16.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (32, N'KH002', N'003', 1, CAST(N'2019-11-21 15:21:58.000' AS DateTime), CAST(N'2019-11-21 15:21:58.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 160000.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (38, N'KH001', N'007', 1, CAST(N'2019-11-21 18:16:22.000' AS DateTime), CAST(N'2019-11-21 18:16:22.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (39, N'KH001', N'008', 1, CAST(N'2019-11-21 18:19:19.000' AS DateTime), CAST(N'2019-11-21 18:19:19.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (40, N'KH001', N'005', 1, CAST(N'2019-11-21 18:43:07.000' AS DateTime), CAST(N'2019-11-21 18:43:07.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (42, N'KH001', N'010', 1, CAST(N'2019-11-21 18:48:09.000' AS DateTime), CAST(N'2019-11-21 18:48:09.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (43, N'KH001', N'004', 1, CAST(N'2019-11-22 00:16:28.000' AS DateTime), CAST(N'2019-11-22 00:16:28.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (44, N'KH001', N'006', 1, CAST(N'2019-11-22 00:16:46.000' AS DateTime), CAST(N'2019-11-22 00:16:46.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 100000.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (45, N'KH002', N'004', 1, CAST(N'2019-11-22 00:51:08.000' AS DateTime), CAST(N'2019-11-23 00:51:08.000' AS DateTime), 2, N'admin', N'Đã thanh toán', 100000.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (46, N'kh003', N'011', 1, CAST(N'2019-11-22 00:51:34.000' AS DateTime), CAST(N'2019-11-24 00:51:34.000' AS DateTime), 3, N'admin', N'Đã thanh toán', 500000.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (47, N'KH001', N'012', 1, CAST(N'2019-11-22 01:00:54.000' AS DateTime), CAST(N'2019-11-22 01:00:54.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (48, N'KH001', N'013', 1, CAST(N'2019-11-22 01:03:39.000' AS DateTime), CAST(N'2019-11-22 01:03:39.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (49, N'KH001', N'014', 1, CAST(N'2019-11-22 08:03:12.000' AS DateTime), CAST(N'2019-11-22 08:01:50.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (50, N'KH001', N'015', 0, CAST(N'2019-11-22 08:08:52.000' AS DateTime), CAST(N'2019-11-23 08:08:52.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 500000.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (51, N'KH005', N'016', 0, CAST(N'2019-11-22 14:33:37.000' AS DateTime), CAST(N'2019-11-23 14:33:37.000' AS DateTime), 2, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (52, N'KH005', N'017', 0, CAST(N'2019-11-22 14:34:23.000' AS DateTime), CAST(N'2019-11-23 14:34:23.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (53, N'KH001', N'018', 0, CAST(N'2019-11-22 22:44:21.000' AS DateTime), CAST(N'2019-11-22 22:44:21.000' AS DateTime), 3, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (54, N'KH001', N'019', 0, CAST(N'2019-11-22 22:45:48.000' AS DateTime), CAST(N'2019-11-23 00:00:00.000' AS DateTime), 2, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (55, N'KH001', N'020', 0, CAST(N'2019-11-22 22:46:52.000' AS DateTime), CAST(N'2019-11-23 12:00:00.000' AS DateTime), 3, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (56, N'KH001', N'021', 0, CAST(N'2019-11-23 00:12:43.000' AS DateTime), CAST(N'2019-11-24 12:00:00.000' AS DateTime), 2, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (57, N'KH001', N'022', 0, CAST(N'2019-11-23 00:16:04.000' AS DateTime), CAST(N'2019-11-24 00:16:04.000' AS DateTime), 2, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (58, N'KH001', N'023', 0, CAST(N'2019-11-23 09:52:37.000' AS DateTime), CAST(N'2019-11-24 09:52:37.000' AS DateTime), 2, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (59, N'KH001', N'024', 0, CAST(N'2019-11-23 10:55:30.000' AS DateTime), CAST(N'2019-11-24 10:55:30.000' AS DateTime), 2, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (60, N'KH001', N'025', 0, CAST(N'2019-11-23 11:49:29.000' AS DateTime), CAST(N'2019-11-24 11:49:29.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (61, N'kh004', N'026', 0, CAST(N'2019-11-23 14:29:42.000' AS DateTime), CAST(N'2019-11-24 14:27:21.000' AS DateTime), 6, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (62, N'KH001', N'001', 1, CAST(N'2019-11-25 19:46:39.000' AS DateTime), CAST(N'2019-11-25 19:46:39.000' AS DateTime), 2, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (63, N'KH001', N'002', 1, CAST(N'2019-11-25 19:47:43.000' AS DateTime), CAST(N'2019-11-25 19:47:43.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (64, N'KH002', N'001', 0, CAST(N'2019-11-25 19:50:30.000' AS DateTime), CAST(N'2019-11-26 19:50:30.000' AS DateTime), 2, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (65, N'KH001', N'001', 1, CAST(N'2019-11-25 19:55:55.000' AS DateTime), CAST(N'2019-11-25 19:55:55.000' AS DateTime), 2, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (66, N'KH001', N'001', 1, CAST(N'2019-11-25 19:57:48.000' AS DateTime), CAST(N'2019-11-25 19:57:48.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (67, N'KH001', N'001', 1, CAST(N'2019-11-26 00:00:36.000' AS DateTime), CAST(N'2019-11-26 00:00:36.000' AS DateTime), 2, N'admin', N'Đã thanh toán', 1000000.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (68, N'KH001', N'001', 1, CAST(N'2019-11-26 12:31:17.000' AS DateTime), CAST(N'2019-11-26 12:31:17.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (69, N'KH001', N'002', 1, CAST(N'2019-11-26 12:39:30.000' AS DateTime), CAST(N'2019-11-26 12:39:30.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (70, N'KH001', N'003', 1, CAST(N'2019-11-26 12:41:04.000' AS DateTime), CAST(N'2019-11-26 12:41:04.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (71, N'KH001', N'004', 1, CAST(N'2019-11-26 12:58:32.000' AS DateTime), CAST(N'2019-11-26 12:58:32.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (72, N'KH005', N'005', 0, CAST(N'2019-11-26 15:42:53.000' AS DateTime), CAST(N'2019-11-27 15:42:53.000' AS DateTime), 2, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (73, N'KH001', N'006', 0, CAST(N'2019-11-26 15:43:58.000' AS DateTime), CAST(N'2019-11-27 15:43:58.000' AS DateTime), 2, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (1067, N'123', N'001', 0, CAST(N'2019-12-04 19:06:55.000' AS DateTime), CAST(N'2019-12-05 19:06:55.000' AS DateTime), 3, N'admin', N'Đã thanh toán', 100000.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (1068, N'khmoi', N'002', 0, CAST(N'2019-12-11 17:14:19.000' AS DateTime), CAST(N'2019-12-12 17:14:19.000' AS DateTime), 2, N'admin', N'Đã thanh toán', 500000.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (1069, N'123', N'001', 0, CAST(N'2019-12-12 19:17:56.000' AS DateTime), CAST(N'2019-12-13 19:17:56.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 100000.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (1070, N'123', N'002', 1, CAST(N'2019-12-22 01:00:06.000' AS DateTime), CAST(N'2019-12-22 01:00:06.000' AS DateTime), 3, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (1071, N'123', N'003', 1, CAST(N'2019-12-22 19:59:18.000' AS DateTime), CAST(N'2019-12-22 19:59:18.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (1072, N'KH002', N'004', 1, CAST(N'2019-12-23 08:28:45.000' AS DateTime), CAST(N'2019-12-23 08:28:45.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 100000.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (1073, N'KH002', N'006', 0, CAST(N'2019-12-23 08:29:21.000' AS DateTime), CAST(N'2019-12-25 08:29:21.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 0.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (1074, N'KH006', N'001', 0, CAST(N'2019-12-23 11:18:20.000' AS DateTime), CAST(N'2019-12-25 11:17:04.000' AS DateTime), 2, N'admin', N'Đã thanh toán', 100000.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (1075, N'KH123', N'005', 0, CAST(N'2019-12-23 11:25:05.000' AS DateTime), CAST(N'2019-12-24 11:23:26.000' AS DateTime), 2, N'admin', N'Đã thanh toán', 100000.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (1076, N'123', N'002', 1, CAST(N'2019-12-28 16:05:53.000' AS DateTime), CAST(N'2019-12-28 16:05:53.000' AS DateTime), 1, N'admin', N'Đã thanh toán', 200000.0000)
INSERT [dbo].[DatPhong] ([MaDatPhong], [MaKhachHang], [MaPhong], [LoaiHinhThue], [NgayThue], [NgayRaDuKien], [SoNguoi], [TenUser], [TinhTrang], [TienDatCoc]) VALUES (1077, N'KH321', N'007', 1, CAST(N'2020-01-06 14:10:51.000' AS DateTime), CAST(N'2020-01-06 14:09:24.000' AS DateTime), 2, N'admin', N'Đã thanh toán', 100000.0000)
SET IDENTITY_INSERT [dbo].[DatPhong] OFF
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonVi], [DonGia], [GhiChu]) VALUES (N'dv00123', N'nước dừa đê', N'cái', 10000.0000, N'')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonVi], [DonGia], [GhiChu]) VALUES (N'dv01', N'nước ngọt', N'lon', 10000.0000, N'nước ngọt cực mạnh')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonVi], [DonGia], [GhiChu]) VALUES (N'dv010', N'giặt đồ', N'kg', 50000.0000, N'giặt đồ is the best')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonVi], [DonGia], [GhiChu]) VALUES (N'dv02', N'bia', N'lon', 16000.0000, N'')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonVi], [DonGia], [GhiChu]) VALUES (N'dv03', N'khăn ướt', N'cái', 1000.0000, N'')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonVi], [DonGia], [GhiChu]) VALUES (N'dv04', N'mỳ tôm hảo hảo', N'lon', 3000.0000, N'mỳ tôm y như quảng cáo')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonVi], [DonGia], [GhiChu]) VALUES (N'dv05', N'my 3 mien', N'cái', 3000.0000, N'')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonVi], [DonGia], [GhiChu]) VALUES (N'dv06', N'asfasf', N'lon', 2000.0000, N'')
INSERT [dbo].[DichVu] ([MaDichVu], [TenDichVu], [DonVi], [DonGia], [GhiChu]) VALUES (N'dv07', N'asfasf', N'chai', 2000.0000, N'ádff')
SET IDENTITY_INSERT [dbo].[HoaDon] ON 

INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (1, 23, N'admin', N'trường31', N'004', 0, 52, 4680000.0000, NULL, NULL, 0.0000, 4680000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (2, 24, N'admin', N'wwtf', N'006', 1, 0, 200000.0000, NULL, NULL, 40000.0000, 240000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (3, 22, N'admin', N'Chí Phèo', N'003', 0, 55, 4400000.0000, NULL, NULL, 27000.0000, 4427000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (4, 25, N'admin', N'Chí Phèo', N'005', 0, 0, 100000.0000, NULL, NULL, 0.0000, 100000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (5, 26, N'admin', N'duc phuc', N'001', 0, 0, 60000.0000, NULL, NULL, 0.0000, 60000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (6, 27, N'admin', N'Chí Phèo', N'007', 0, 0, 60000.0000, NULL, NULL, 393000.0000, 453000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (7, 23, N'admin', N'trường31', N'004', 0, 70, 6300000.0000, NULL, NULL, 40000.0000, 6340000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (8, 28, N'admin', N'yasuo', N'008', 0, 11, 660000.0000, NULL, NULL, 56000.0000, 716000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (9, 40, N'admin', N'Trần Quang Trường', N'005', 0, 0, 100000.0000, NULL, NULL, 0.0000, 100000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (10, 39, N'admin', N'Trần Quang Trường', N'008', 0, 0, 60000.0000, NULL, NULL, 0.0000, 60000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (11, 38, N'admin', N'Trần Quang Trường', N'007', 0, 0, 60000.0000, NULL, NULL, 0.0000, 60000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (12, 31, N'admin', N'duc phuc', N'001', 0, 0, 200000.0000, NULL, NULL, 80000.0000, 280000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (13, 32, N'admin', N'Chí Phèo', N'003', 0, 3, 240000.0000, NULL, NULL, 0.0000, 240000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (14, 29, N'admin', N'trường31', N'009', 0, 35, 2100000.0000, NULL, NULL, 124000.0000, 2224000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (15, 30, N'admin', N'Trần Quang Trường', N'002', 0, 3, 210000.0000, NULL, NULL, 0.0000, 210000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (16, 61, N'admin', N'trường31', N'026', 1, 65, 200000.0000, NULL, NULL, 394000.0000, 694000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (17, 60, N'admin', N'Trần Quang Trường', N'025', 1, 65, 200000.0000, NULL, NULL, 0.0000, 300000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (18, 59, N'admin', N'Trần Quang Trường', N'024', 1, 65, 200000.0000, NULL, NULL, 0.0000, 360000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (19, 58, N'admin', N'Trần Quang Trường', N'023', 1, 65, 200000.0000, NULL, NULL, 0.0000, 360000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (20, 57, N'admin', N'Trần Quang Trường', N'022', 1, 65, 200000.0000, NULL, NULL, 0.0000, 400000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (21, 56, N'admin', N'Trần Quang Trường', N'021', 1, 65, 200000.0000, NULL, NULL, 0.0000, 400000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (22, 55, N'admin', N'Trần Quang Trường', N'020', 1, 65, 200000.0000, NULL, NULL, 0.0000, 300000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (23, 54, N'admin', N'Trần Quang Trường', N'019', 1, 65, 200000.0000, NULL, NULL, 0.0000, 300000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (24, 53, N'admin', N'Trần Quang Trường', N'018', 1, 65, 200000.0000, NULL, NULL, 0.0000, 300000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (25, 52, N'admin', N'duc phuc', N'017', 2, 65, 400000.0000, NULL, NULL, 0.0000, 500000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (26, 51, N'admin', N'duc phuc', N'016', 2, 65, 400000.0000, NULL, NULL, 0.0000, 500000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (27, 49, N'admin', N'Trần Quang Trường', N'014', 2, 57, 3420000.0000, NULL, NULL, 0.0000, 3420000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (28, 48, N'admin', N'Trần Quang Trường', N'013', 2, 64, 3840000.0000, NULL, NULL, 0.0000, 3840000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (29, 47, N'admin', N'Trần Quang Trường', N'012', 2, 64, 3840000.0000, NULL, NULL, 0.0000, 3840000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (30, 46, N'admin', N'trường123', N'011', 2, 65, 3900000.0000, NULL, NULL, 0.0000, 3400000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (31, 45, N'admin', N'Chí Phèo', N'004', 2, 65, 5850000.0000, NULL, NULL, 0.0000, 5750000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (32, 44, N'admin', N'Trần Quang Trường', N'006', 2, 65, 3900000.0000, NULL, NULL, 0.0000, 3800000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (33, 42, N'admin', N'Trần Quang Trường', N'010', 2, 71, 4260000.0000, NULL, NULL, 0.0000, 4260000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (35, 63, N'admin', N'Trần Quang Trường', N'002', 0, 1, 70000.0000, NULL, NULL, 0.0000, 70000.0000, CAST(N'2019-11-25' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (38, 66, N'admin', N'Trần Quang Trường', N'001', 0, 1, 60000.0000, NULL, NULL, 0.0000, 60000.0000, CAST(N'2019-11-25' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (39, 67, N'admin', N'Trần Quang Trường', N'001', 0, 1, 60000.0000, NULL, NULL, 474000.0000, -466000.0000, NULL, NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (40, 71, N'admin', N'Trần Quang Trường', N'004', 0, 1, 90000.0000, 0.0000, 0.0000, 0.0000, 90000.0000, CAST(N'2019-11-26' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (1039, 1067, N'admin', N'trường', N'001', 2, 0, 400000.0000, 0.0000, 0.0000, 0.0000, 285000.0000, CAST(N'2019-12-07' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (1040, 72, N'admin', N'duc phuc', N'005', 10, 0, 10000000.0000, 0.0000, 0.0000, 120000.0000, 10120000.0000, CAST(N'2019-12-07' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (1041, 73, N'admin', N'Trần Quang Trường', N'006', 15, 0, 3000000.0000, 0.0000, 100000.0000, 32000.0000, 3132000.0000, CAST(N'2019-12-11' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (1042, 1068, N'admin', N'wwtf', N'002', 1, 0, 300000.0000, 0.0000, 150000.0000, 40000.0000, -10000.0000, CAST(N'2019-12-12' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (1043, 1070, N'admin', N'trường', N'002', 0, 22, 1540000.0000, 0.0000, 0.0000, 0.0000, 1386000.0000, CAST(N'2019-12-22' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (1044, 1075, N'admin', N'trường123', N'005', 1, 2, 1000000.0000, 0.0000, 0.0000, 33000.0000, 933000.0000, CAST(N'2019-12-23' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (1045, 1074, N'admin', N'trường quang', N'001', 1, 2, 200000.0000, 0.0000, 0.0000, 434000.0000, 534000.0000, CAST(N'2019-12-23' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (1046, 1073, N'admin', N'Chí Phèo', N'006', 5, 0, 1000000.0000, 60000.0000, 100000.0000, 20000.0000, 1180000.0000, CAST(N'2019-12-28' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (1047, 1072, N'admin', N'Chí Phèo', N'004', 0, 127, 11430000.0000, 0.0000, 0.0000, 0.0000, 11330000.0000, CAST(N'2019-12-28' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (1048, 1071, N'admin', N'trường', N'003', 0, 140, 11200000.0000, 0.0000, 0.0000, 0.0000, 10080000.0000, CAST(N'2019-12-28' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (1049, 1077, N'admin', N'trường', N'007', 0, 28, 1680000.0000, 0.0000, 0.0000, 1000.0000, 1581000.0000, CAST(N'2020-01-07' AS Date), NULL)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaDatPhong], [TenUser], [TenKhachHang], [MaPhong], [SoNgayThue], [SoGioThue], [TienPhong], [PhuThuCheckin], [PhuThuCheckout], [TienDichVu], [ThanhTien], [NgayThanhToan], [GhiChu]) VALUES (1050, 1076, N'admin', N'trường', N'002', 0, 242, 16940000.0000, 0.0000, 0.0000, 30000.0000, 15093000.0000, CAST(N'2020-01-07' AS Date), NULL)
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
SET IDENTITY_INSERT [dbo].[Khac] ON 

INSERT [dbo].[Khac] ([ID], [GiaTriSo], [GiaTriTG], [MoTa]) VALUES (3, 6, CAST(N'12:00:00' AS Time), N'qua mốc checkin1 ')
INSERT [dbo].[Khac] ([ID], [GiaTriSo], [GiaTriTG], [MoTa]) VALUES (4, 1, CAST(N'12:00:00' AS Time), N'quá mốc checkin2')
INSERT [dbo].[Khac] ([ID], [GiaTriSo], [GiaTriTG], [MoTa]) VALUES (5, 2, CAST(N'14:00:00' AS Time), N'mốc checkout2')
INSERT [dbo].[Khac] ([ID], [GiaTriSo], [GiaTriTG], [MoTa]) VALUES (6, 5, CAST(N'14:00:00' AS Time), N'mốc checkout1')
INSERT [dbo].[Khac] ([ID], [GiaTriSo], [GiaTriTG], [MoTa]) VALUES (7, 30, NULL, N'phụ thu checkin1')
INSERT [dbo].[Khac] ([ID], [GiaTriSo], [GiaTriTG], [MoTa]) VALUES (8, 50, NULL, N'phụ thu checkin2')
INSERT [dbo].[Khac] ([ID], [GiaTriSo], [GiaTriTG], [MoTa]) VALUES (9, 20, NULL, N'phụ thu checkout1')
INSERT [dbo].[Khac] ([ID], [GiaTriSo], [GiaTriTG], [MoTa]) VALUES (10, 30, NULL, N'phụ thu checkout1')
SET IDENTITY_INSERT [dbo].[Khac] OFF
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'123', N'loaiA', N'trường', 20, 0, N'12313123  ', N'1231312     ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'KH001', N'2', N'Trần Quang Trường', 20, 1, N'0123456789', N'012345678912')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'kh0011111', N'loaiA', N'fsáádfsđầ', 2, 0, N'12313123  ', N'123123123   ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'KH001sđá', N'2', N'Trần Quang Trường', 20, 1, N'0123456789', N'012345678912')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'KH002', N'1', N'Chí Phèo', 30, 1, N'0123456789', N'123456789111')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'kh003', N'1', N'trường123', 16, 0, N'          ', N'123123123123')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'kh004', N'2', N'trường31', 13, 0, N'          ', N'123         ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'KH005', N'2', N'duc phuc', 22, 1, N'0123456789', N'123456789111')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'KH006', N'2', N'trường quang', 18, 0, N'          ', N'1231231231  ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'kh007', N'1', N'yasuo', 6, 0, N'123       ', N'123         ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'KH123', N'1', N'trường123', 18, 1, N'          ', N'1231231231  ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'KH1234', N'loaiA', N'trường321', 18, 1, N'          ', N'1231231231  ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'KH321', N'1', N'trường', 18, 1, N'12312312  ', N'1231231231  ')
INSERT [dbo].[KhachHang] ([MaKhachHang], [MaLoaiKH], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCMND]) VALUES (N'khmoi', N'1', N'wwtf', 7, 0, N'          ', N'1231231231  ')
INSERT [dbo].[LoaiKhachHang] ([MaLoaiKH], [TenLoaiKH], [TienGiam], [MoTa]) VALUES (N'1', N'Khách vãn lai', 0, N'')
INSERT [dbo].[LoaiKhachHang] ([MaLoaiKH], [TenLoaiKH], [TienGiam], [MoTa]) VALUES (N'2', N'Khách quen', 0, N'')
INSERT [dbo].[LoaiKhachHang] ([MaLoaiKH], [TenLoaiKH], [TienGiam], [MoTa]) VALUES (N'loaiA', N'khách tây ba lô', 10, N'âfadfsấdf')
INSERT [dbo].[LoaiKhachHang] ([MaLoaiKH], [TenLoaiKH], [TienGiam], [MoTa]) VALUES (N'loaib', N'khách khách', 101, N'khách alskdjfálkdf d')
INSERT [dbo].[LoaiKhachHang] ([MaLoaiKH], [TenLoaiKH], [TienGiam], [MoTa]) VALUES (N'loaiC', N'ádfádfádfád', 5, N'')
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiuongDon], [GiuongDoi], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'1', N'Phòng bình dân', NULL, NULL, 60000.0000, 200000.0000)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiuongDon], [GiuongDoi], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'4', N'Phòng Superior (SUP)', NULL, NULL, 70000.0000, 300000.0000)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiuongDon], [GiuongDoi], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'5', N'Phòng Deluxe (DLX)', NULL, NULL, 80000.0000, 400000.0000)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiuongDon], [GiuongDoi], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'6', N'Phòng Suite (SUT)', NULL, NULL, 90000.0000, 500000.0000)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiuongDon], [GiuongDoi], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'7', N'Connecting room', NULL, NULL, 100000.0000, 1000000.0000)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiuongDon], [GiuongDoi], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'8', N'phòng sadklfjsa', NULL, NULL, 100000.0000, 50000.0000)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiuongDon], [GiuongDoi], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'LoaiB', N'phong phó tổng thống', NULL, NULL, 500000.0000, 200000.0000)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiuongDon], [GiuongDoi], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'phongq3', N'phòng bình dân2', NULL, NULL, 65000.0000, 200000.0000)
INSERT [dbo].[Luong] ([MaLuong], [LuongTheoGio], [SoGioLam], [GhiChu]) VALUES (N'lương tổng thống', 100000.0000, 4, N'')
INSERT [dbo].[Luong] ([MaLuong], [LuongTheoGio], [SoGioLam], [GhiChu]) VALUES (N'LuongNhanVien', 20000.0000, 8, N'sadfádfấdf')
INSERT [dbo].[Luong] ([MaLuong], [LuongTheoGio], [SoGioLam], [GhiChu]) VALUES (N'LuongNhanVien2', 18000.0000, 8, N'2019-02-02')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'ád;kfl', N'Quang Hải', 1, CAST(N'2019-11-14' AS Date), N'1122334455', N'LuongNhanVien2', N'việt nam number one', N'70928777_2888992324463176_489800089070469120_n.jpg', CAST(N'2020-01-07' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'fsfsd', N'Trần quang trường', 1, CAST(N'2012-12-12' AS Date), N'1231231231', N'LuongNhanVien', N'việt nam numbẻ one', N'security.png', CAST(N'2018-12-12' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'fsfsdìa', N'Trần quang trường', 1, CAST(N'2012-12-12' AS Date), N'1231231231', N'LuongNhanVien', N'việt nam numbẻ one', N'security.png', CAST(N'2020-01-06' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'hahah', N'Quá Nhi', 1, CAST(N'2000-11-03' AS Date), N'1231231231', N'LuongNhanVien', N'', N'71334139_170073104174286_3245189035869601792_n.jpg', CAST(N'2019-12-04' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV001', N'admin', 0, CAST(N'2019-01-01' AS Date), N'123123123 ', N'LuongNhanVien2', N'China', N'TranDanCuTe.jpg', CAST(N'2019-12-04' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV002', N'quang truong', 0, CAST(N'2000-01-01' AS Date), N'1234567890', N'LuongNhanVien', N'', N'', CAST(N'2019-12-04' AS Date), N'một con vịt xòe ra hai cái cánh')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV003', N'Trứng', 1, CAST(N'1999-01-01' AS Date), N'123       ', N'LuongNhanVien2', N'Thái lan', N'null', CAST(N'2019-12-04' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV004', N'Chí Phèo', 1, CAST(N'1900-01-01' AS Date), N'123       ', N'LuongNhanVien2', N'321', N'null', CAST(N'2019-12-04' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'nv005', N'trường 123', 1, CAST(N'1996-11-01' AS Date), N'1231231231', N'LuongNhanVien', N'dfá', N'null', CAST(N'2019-12-04' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV006', N'Võ Tá Thiện', 0, CAST(N'2000-12-01' AS Date), N'3122311231', N'LuongNhanVien', N'buôn ma thuột', N'70038650_256266618681367_2578439927746265088_n.jpg', CAST(N'2019-12-23' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'NV010', N'Ngọc Ngạn', 1, CAST(N'1992-12-01' AS Date), N'1231231231', N'lương tổng thống', N'', N'null', CAST(N'2019-12-01' AS Date), N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [MaLuong], [DiaChi], [Hinh], [NgayBatDauLam], [GhiChu]) VALUES (N'sldfkja', N'đỗ minh đức', 1, CAST(N'2000-11-01' AS Date), N'3122311231', N'LuongNhanVien', N'buôn ma thuột', N'70038650_256266618681367_2578439927746265088_n.jpg', CAST(N'2019-12-04' AS Date), N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'001', N'1', 20, 1, 1, 0, N'C:\Users\ADMIN\Desktop\Untitled-1.png', N'dondep', N'hello')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'002', N'4', 30, 1, 2, 0, N'null', N'dondep', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'003', N'5', 40, 1, 1, 0, N'null', N'dondep', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'004', N'6', 50, 1, 1, 1, NULL, N'dondep', NULL)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'005', N'7', 50, 1, 1, 1, NULL, N'dondep', NULL)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'006', N'1', 20, 1, 1, 0, NULL, N'dondep', NULL)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'007', N'1', 20, 1, 1, 0, NULL, N'dondep', NULL)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'008', N'1', 11, 1, 1, 0, N'C:\Users\ADMIN\Desktop\security.png', N'trong', N'hello')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'009', N'1', 20, 1, 1, 0, N'null', N'trong', N'sdfaffsa')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'010', N'1', 20, 1, 1, 0, N'null', N'trong', N'werqytrytjrq')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'011', N'1', 20, 1, 1, 0, N'null', N'trong', N'werqytrytjrq')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'012', N'1', 20, 1, 1, 0, N'null', N'trong', N'werqytrytjrq')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'013', N'1', 20, 1, 1, 0, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'014', N'1', 30, 2, 2, 0, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'015', N'1', 20, 2, 1, 0, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'016', N'1', 20, 2, 1, 0, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'017', N'1', 20, 2, 1, 0, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'018', N'1', 20, 2, 1, 0, N'security.png', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'019', N'1', 20, 3, 1, 0, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'020', N'1', 20, 2, 1, 0, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'021', N'1', 20, 2, 1, 0, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'022', N'1', 20, 3, 1, 0, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'023', N'1', 20, 3, 1, 0, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'024', N'1', 20, 3, 1, 0, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'025', N'1', 20, 3, 1, 0, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'026', N'1', 20, 3, 1, 0, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'027', N'1', 20, 4, 1, 0, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'028', N'1', 20, 4, 1, 0, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'029', N'1', 20, 4, 1, 0, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'030', N'1', 20, 4, 1, 0, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'031', N'1', 20, 4, 1, 0, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'123', N'1', 0, 6, 1, 1, N'null', N'trong', N'')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'p312', N'4', 20, 1, 1, 0, N'null', N'trong', N'sdấ')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'Phong001', N'phongq3', 20, 5, 1, 0, N'null', N'trong', N'hi')
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [DienTich], [MaTang], [GiuongDon], [GiuongDoi], [Hinh], [TinhTrang], [GhiChu]) VALUES (N'phongVIP', N'6', 50, 5, 1, 0, N'security.png', N'trong', N'')
INSERT [dbo].[Quyen] ([MaQuyen], [TenQuyen], [MoTa]) VALUES (N'NhanVien', N'Nhân viên', NULL)
INSERT [dbo].[Quyen] ([MaQuyen], [TenQuyen], [MoTa]) VALUES (N'QuanLy', N'Quản lý', NULL)
INSERT [dbo].[User] ([TenUser], [MatKhau], [NgayLap], [MaQuyen], [GhiChu], [MaNhanVien]) VALUES (N'admin', N'admin', CAST(N'2019-11-07' AS Date), N'QuanLy', NULL, N'NV001')
INSERT [dbo].[User] ([TenUser], [MatKhau], [NgayLap], [MaQuyen], [GhiChu], [MaNhanVien]) VALUES (N'truong', N'truong123', CAST(N'2019-11-09' AS Date), N'NhanVien', NULL, N'NV002')
INSERT [dbo].[User] ([TenUser], [MatKhau], [NgayLap], [MaQuyen], [GhiChu], [MaNhanVien]) VALUES (N'truongdeptrainhatxom', N'123456', CAST(N'2019-12-01' AS Date), N'QuanLy', NULL, N'ád;kfl')
ALTER TABLE [dbo].[ChiTietDichVu]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDichVu_DatPhong] FOREIGN KEY([MaDatPhong])
REFERENCES [dbo].[DatPhong] ([MaDatPhong])
GO
ALTER TABLE [dbo].[ChiTietDichVu] CHECK CONSTRAINT [FK_ChiTietDichVu_DatPhong]
GO
ALTER TABLE [dbo].[ChiTietDichVu]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDichVu_DichVu] FOREIGN KEY([MaDichVu])
REFERENCES [dbo].[DichVu] ([MaDichVu])
GO
ALTER TABLE [dbo].[ChiTietDichVu] CHECK CONSTRAINT [FK_ChiTietDichVu_DichVu]
GO
ALTER TABLE [dbo].[ChiTietLuong]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietLuong_NhanVien] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
GO
ALTER TABLE [dbo].[ChiTietLuong] CHECK CONSTRAINT [FK_ChiTietLuong_NhanVien]
GO
ALTER TABLE [dbo].[DatPhong]  WITH CHECK ADD  CONSTRAINT [FK_DatPhong_KhachHang] FOREIGN KEY([MaKhachHang])
REFERENCES [dbo].[KhachHang] ([MaKhachHang])
GO
ALTER TABLE [dbo].[DatPhong] CHECK CONSTRAINT [FK_DatPhong_KhachHang]
GO
ALTER TABLE [dbo].[DatPhong]  WITH CHECK ADD  CONSTRAINT [FK_DatPhong_Phong] FOREIGN KEY([MaPhong])
REFERENCES [dbo].[Phong] ([MaPhong])
GO
ALTER TABLE [dbo].[DatPhong] CHECK CONSTRAINT [FK_DatPhong_Phong]
GO
ALTER TABLE [dbo].[DatPhong]  WITH CHECK ADD  CONSTRAINT [FK_DatPhong_User] FOREIGN KEY([TenUser])
REFERENCES [dbo].[User] ([TenUser])
GO
ALTER TABLE [dbo].[DatPhong] CHECK CONSTRAINT [FK_DatPhong_User]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_DatPhong] FOREIGN KEY([MaDatPhong])
REFERENCES [dbo].[DatPhong] ([MaDatPhong])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_DatPhong]
GO
ALTER TABLE [dbo].[KhachHang]  WITH CHECK ADD  CONSTRAINT [FK_KhachHang_LoaiKhachHang] FOREIGN KEY([MaLoaiKH])
REFERENCES [dbo].[LoaiKhachHang] ([MaLoaiKH])
GO
ALTER TABLE [dbo].[KhachHang] CHECK CONSTRAINT [FK_KhachHang_LoaiKhachHang]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_Luong] FOREIGN KEY([MaLuong])
REFERENCES [dbo].[Luong] ([MaLuong])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_Luong]
GO
ALTER TABLE [dbo].[Phong]  WITH CHECK ADD  CONSTRAINT [FK_Phong_LoaiPhong] FOREIGN KEY([MaLoaiPhong])
REFERENCES [dbo].[LoaiPhong] ([MaLoaiPhong])
GO
ALTER TABLE [dbo].[Phong] CHECK CONSTRAINT [FK_Phong_LoaiPhong]
GO
ALTER TABLE [dbo].[User]  WITH CHECK ADD  CONSTRAINT [FK_User_NhanVien] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
GO
ALTER TABLE [dbo].[User] CHECK CONSTRAINT [FK_User_NhanVien]
GO
ALTER TABLE [dbo].[User]  WITH CHECK ADD  CONSTRAINT [FK_User_Quyen] FOREIGN KEY([MaQuyen])
REFERENCES [dbo].[Quyen] ([MaQuyen])
GO
ALTER TABLE [dbo].[User] CHECK CONSTRAINT [FK_User_Quyen]
GO
USE [master]
GO
ALTER DATABASE [QuanLyKhachSan] SET  READ_WRITE 
GO
