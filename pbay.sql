USE [master]
GO
/****** Object:  Database [pbaydb]    Script Date: 2020-11-17 5:13:11 PM ******/
CREATE DATABASE [pbaydb]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'pbaydb', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\pbaydb.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'pbaydb_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\pbaydb_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [pbaydb] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [pbaydb].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [pbaydb] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [pbaydb] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [pbaydb] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [pbaydb] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [pbaydb] SET ARITHABORT OFF 
GO
ALTER DATABASE [pbaydb] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [pbaydb] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [pbaydb] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [pbaydb] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [pbaydb] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [pbaydb] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [pbaydb] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [pbaydb] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [pbaydb] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [pbaydb] SET  DISABLE_BROKER 
GO
ALTER DATABASE [pbaydb] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [pbaydb] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [pbaydb] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [pbaydb] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [pbaydb] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [pbaydb] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [pbaydb] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [pbaydb] SET RECOVERY FULL 
GO
ALTER DATABASE [pbaydb] SET  MULTI_USER 
GO
ALTER DATABASE [pbaydb] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [pbaydb] SET DB_CHAINING OFF 
GO
ALTER DATABASE [pbaydb] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [pbaydb] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [pbaydb] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [pbaydb] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'pbaydb', N'ON'
GO
ALTER DATABASE [pbaydb] SET QUERY_STORE = OFF
GO
USE [pbaydb]
GO
/****** Object:  User [simpleuser]    Script Date: 2020-11-17 5:13:11 PM ******/
CREATE USER [simpleuser] FOR LOGIN [simpleuser] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_datareader] ADD MEMBER [simpleuser]
GO
ALTER ROLE [db_datawriter] ADD MEMBER [simpleuser]
GO
/****** Object:  Table [dbo].[biddings]    Script Date: 2020-11-17 5:13:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[biddings](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[listing_id] [bigint] NULL,
	[user_id] [bigint] NULL,
	[price] [decimal](10, 2) NULL,
	[currency_id] [bigint] NULL,
	[active] [tinyint] NULL,
	[created_at] [datetime] NULL,
 CONSTRAINT [PK_biddings] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[billing_address]    Script Date: 2020-11-17 5:13:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[billing_address](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[user_id] [bigint] NULL,
	[country_code] [varchar](3) NULL,
	[city] [varchar](250) NULL,
	[region] [varchar](250) NULL,
	[street] [varchar](250) NULL,
	[street_no] [varchar](50) NULL,
	[post_code] [varchar](25) NULL,
	[surname] [varchar](150) NULL,
	[name] [varchar](150) NULL,
 CONSTRAINT [PK_billing_address] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[continents]    Script Date: 2020-11-17 5:13:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[continents](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[code] [varchar](3) NULL,
	[title] [varchar](50) NULL,
 CONSTRAINT [PK_continents] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[countries]    Script Date: 2020-11-17 5:13:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[countries](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[code] [varchar](2) NULL,
	[title] [varchar](60) NULL,
	[continent_id] [bigint] NULL,
 CONSTRAINT [PK_countries] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[currencies]    Script Date: 2020-11-17 5:13:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[currencies](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[code] [varchar](4) NULL,
 CONSTRAINT [PK_currencies] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[currency_rates]    Script Date: 2020-11-17 5:13:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[currency_rates](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[fromCur] [varchar](3) NULL,
	[toCur] [varchar](3) NULL,
	[rate] [decimal](10, 2) NULL,
 CONSTRAINT [PK_currency_rates] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[listings]    Script Date: 2020-11-17 5:13:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[listings](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[selling_id] [bigint] NULL,
	[currency_id] [bigint] NULL,
	[price] [decimal](10, 2) NULL,
	[fee_euro] [decimal](10, 2) NULL,
	[active_from] [datetime] NULL,
	[active_until] [datetime] NULL,
	[watchers] [int] NULL,
	[is_action] [tinyint] NULL,
 CONSTRAINT [PK_listings] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[shipping_address]    Script Date: 2020-11-17 5:13:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[shipping_address](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[user_id] [bigint] NULL,
	[country_code] [varchar](3) NULL,
	[city] [varchar](250) NULL,
	[region] [varchar](250) NULL,
	[street] [varchar](250) NULL,
	[street_no] [varchar](50) NULL,
	[post_code] [varchar](25) NULL,
	[surname] [varchar](150) NULL,
	[name] [varchar](150) NULL,
 CONSTRAINT [PK_shipping_address] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[currencies] ON 

INSERT [dbo].[currencies] ([id], [code]) VALUES (1, N'EUR')
INSERT [dbo].[currencies] ([id], [code]) VALUES (2, N'CHF')
INSERT [dbo].[currencies] ([id], [code]) VALUES (3, N'USD')
INSERT [dbo].[currencies] ([id], [code]) VALUES (4, N'NOK')
INSERT [dbo].[currencies] ([id], [code]) VALUES (5, N'RUB')
INSERT [dbo].[currencies] ([id], [code]) VALUES (6, N'SEK')
INSERT [dbo].[currencies] ([id], [code]) VALUES (7, N'DKK')
SET IDENTITY_INSERT [dbo].[currencies] OFF
GO
USE [master]
GO
ALTER DATABASE [pbaydb] SET  READ_WRITE 
GO
