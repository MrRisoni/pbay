USE [master]
GO
/****** Object:  Database [pbaydb]    Script Date: 2020-11-17 8:46:16 PM ******/
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
/****** Object:  User [simpleuser]    Script Date: 2020-11-17 8:46:17 PM ******/
CREATE USER [simpleuser] FOR LOGIN [simpleuser] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_datareader] ADD MEMBER [simpleuser]
GO
ALTER ROLE [db_datawriter] ADD MEMBER [simpleuser]
GO
/****** Object:  Table [dbo].[biddings]    Script Date: 2020-11-17 8:46:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[biddings](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[listing_id] [bigint] NULL,
	[user_id] [bigint] NULL,
	[price] [decimal](10, 2) NULL,
	[currency_code] [varchar](3) NULL,
	[active] [tinyint] NULL,
	[created_at] [datetime] NULL,
 CONSTRAINT [PK_biddings] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[billing_address]    Script Date: 2020-11-17 8:46:17 PM ******/
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
/****** Object:  Table [dbo].[continents]    Script Date: 2020-11-17 8:46:17 PM ******/
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
/****** Object:  Table [dbo].[countries]    Script Date: 2020-11-17 8:46:17 PM ******/
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
/****** Object:  Table [dbo].[credit_cards]    Script Date: 2020-11-17 8:46:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[credit_cards](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[order_id] [bigint] NULL,
	[type] [varchar](4) NULL,
	[bin] [varchar](6) NULL,
	[last_four] [varchar](4) NULL,
 CONSTRAINT [PK_credit_cards] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[currencies]    Script Date: 2020-11-17 8:46:17 PM ******/
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
/****** Object:  Table [dbo].[currency_rates]    Script Date: 2020-11-17 8:46:17 PM ******/
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
/****** Object:  Table [dbo].[listing_watchers]    Script Date: 2020-11-17 8:46:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[listing_watchers](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[listing_id] [bigint] NULL,
	[user_id] [bigint] NULL,
	[created_at] [datetime] NULL,
 CONSTRAINT [PK_listing_watchers] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[listings]    Script Date: 2020-11-17 8:46:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[listings](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[selling_id] [bigint] NULL,
	[currency_code] [varchar](3) NULL,
	[price] [decimal](10, 2) NULL,
	[fee_euro] [decimal](10, 2) NULL,
	[active_from] [datetime] NULL,
	[active_until] [datetime] NULL,
	[num_watchers] [int] NULL,
	[is_auction] [tinyint] NULL,
 CONSTRAINT [PK_listings] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[order_item_track_history]    Script Date: 2020-11-17 8:46:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[order_item_track_history](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[item_id] [bigint] NULL,
	[status_id] [bigint] NULL,
	[created_at] [datetime] NULL,
 CONSTRAINT [PK_order_item_track_history] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[order_items]    Script Date: 2020-11-17 8:46:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[order_items](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[order_id] [bigint] NULL,
	[product_id] [bigint] NULL,
	[seller_id] [bigint] NULL,
	[quantity] [int] NULL,
	[tracking_num] [varchar](255) NULL,
	[total] [decimal](10, 2) NULL,
	[goods_total] [decimal](10, 2) NULL,
	[ship_total] [decimal](10, 2) NULL,
	[currency_code] [varchar](3) NULL,
	[rate] [decimal](10, 2) NULL,
	[status_id] [bigint] NULL,
	[is_void] [tinyint] NULL,
 CONSTRAINT [PK_order_items] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[order_status]    Script Date: 2020-11-17 8:46:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[order_status](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[title] [varchar](50) NULL,
 CONSTRAINT [PK_order_status] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[orders]    Script Date: 2020-11-17 8:46:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[orders](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[user_id] [bigint] NULL,
	[billing_address_id] [bigint] NULL,
	[shipping_address_id] [bigint] NULL,
	[payment_method_id] [bigint] NULL,
	[bank_transaction_id] [varchar](250) NULL,
	[total] [decimal](10, 2) NULL,
	[goods_total] [decimal](10, 2) NULL,
	[shipping_total] [decimal](10, 2) NULL,
	[fee] [decimal](10, 2) NULL,
	[currency_code] [varchar](3) NULL,
	[success] [tinyint] NULL,
	[void] [tinyint] NULL,
	[refund] [tinyint] NULL,
	[created_at] [datetime] NULL,
	[updated_at] [datetime] NULL,
 CONSTRAINT [PK_orders] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[payment_methods]    Script Date: 2020-11-17 8:46:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[payment_methods](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[title] [varchar](50) NULL,
 CONSTRAINT [PK_payment_methods] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[product_categories]    Script Date: 2020-11-17 8:46:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product_categories](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[title] [varchar](50) NULL,
 CONSTRAINT [PK_product_categories] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[product_filter_values]    Script Date: 2020-11-17 8:46:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product_filter_values](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[product_id] [bigint] NULL,
	[filter_id] [bigint] NULL,
	[val] [varchar](50) NULL,
 CONSTRAINT [PK_product_filter_values] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[product_filters]    Script Date: 2020-11-17 8:46:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product_filters](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[product_category_id] [bigint] NULL,
	[title] [varchar](50) NULL,
 CONSTRAINT [PK_product_filters] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[products]    Script Date: 2020-11-17 8:46:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[products](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[title] [varchar](250) NULL,
	[other_title] [varchar](250) NULL,
	[description] [text] NULL,
	[category_id] [bigint] NULL,
	[preowned] [tinyint] NULL,
	[weight] [decimal](5, 2) NULL,
	[dim_l] [decimal](5, 2) NULL,
	[dim_w] [decimal](5, 2) NULL,
	[dim_h] [decimal](5, 2) NULL,
 CONSTRAINT [PK_products] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[reviews]    Script Date: 2020-11-17 8:46:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[reviews](
	[id] [bigint] NOT NULL,
	[user_id] [bigint] NULL,
	[item_id] [bigint] NULL,
	[stars] [decimal](2, 1) NULL,
	[created_at] [datetime] NULL,
 CONSTRAINT [PK_reviews] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[seller_review_categories]    Script Date: 2020-11-17 8:46:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[seller_review_categories](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[title] [varchar](50) NULL,
 CONSTRAINT [PK_seller_review_categories] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[seller_reviews]    Script Date: 2020-11-17 8:46:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[seller_reviews](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[seller_id] [bigint] NULL,
	[user_id] [bigint] NULL,
	[order_id] [bigint] NULL,
	[opinion] [tinyint] NULL,
	[comment] [text] NULL,
	[created_at] [nchar](10) NULL,
 CONSTRAINT [PK_seller_reviews] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[seller_reviews_categories_eval]    Script Date: 2020-11-17 8:46:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[seller_reviews_categories_eval](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[review_id] [bigint] NULL,
	[category_id] [bigint] NULL,
	[rating] [decimal](2, 1) NULL,
 CONSTRAINT [PK_seller_reviews_categories_eval] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[sellers]    Script Date: 2020-11-17 8:46:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sellers](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[user_id] [bigint] NULL,
	[country_code] [varchar](3) NULL,
	[title] [varchar](250) NULL,
	[ssn] [varchar](250) NULL,
	[avg_stars] [decimal](3, 2) NULL,
 CONSTRAINT [PK_sellers] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[selling]    Script Date: 2020-11-17 8:46:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[selling](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[seller_id] [bigint] NULL,
	[product_id] [bigint] NULL,
	[quantity] [tinyint] NULL,
	[mailer_company] [varchar](50) NULL,
 CONSTRAINT [PK_selling] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[shipping_address]    Script Date: 2020-11-17 8:46:17 PM ******/
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
/****** Object:  Table [dbo].[shipping_costs]    Script Date: 2020-11-17 8:46:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[shipping_costs](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[selling_id] [bigint] NULL,
	[continent_code] [varchar](3) NULL,
	[cost] [decimal](10, 2) NULL,
 CONSTRAINT [PK_shipping_costs] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[shipping_costs_exceptions]    Script Date: 2020-11-17 8:46:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[shipping_costs_exceptions](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[selling_id] [bigint] NULL,
	[country_code] [varchar](3) NULL,
	[cost] [decimal](10, 2) NULL,
 CONSTRAINT [PK_shipping_costs_exceptions] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[shipping_country_forbidden]    Script Date: 2020-11-17 8:46:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[shipping_country_forbidden](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[selling_id] [bigint] NULL,
	[country_code] [varchar](3) NULL,
 CONSTRAINT [PK_shipping_country_forbidden] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 2020-11-17 8:46:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[email] [varchar](80) NULL,
 CONSTRAINT [PK_users] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[billing_address] ON 

INSERT [dbo].[billing_address] ([id], [user_id], [country_code], [city], [region], [street], [street_no], [post_code], [surname], [name]) VALUES (1, 1, N'GR', N'Athens', N'Faliro', N'Pushkin', N'45', N'17935', N'Alex', N'Tolkien')
SET IDENTITY_INSERT [dbo].[billing_address] OFF
GO
SET IDENTITY_INSERT [dbo].[continents] ON 

INSERT [dbo].[continents] ([id], [code], [title]) VALUES (1, N'EU', N'Europe')
INSERT [dbo].[continents] ([id], [code], [title]) VALUES (2, N'NA', N'North America')
INSERT [dbo].[continents] ([id], [code], [title]) VALUES (3, N'CA', N'Central America')
INSERT [dbo].[continents] ([id], [code], [title]) VALUES (4, N'SA', N'South America')
INSERT [dbo].[continents] ([id], [code], [title]) VALUES (5, N'AS', N'Asia')
INSERT [dbo].[continents] ([id], [code], [title]) VALUES (6, N'AF', N'Africa')
INSERT [dbo].[continents] ([id], [code], [title]) VALUES (7, N'ME', N'Middle East')
SET IDENTITY_INSERT [dbo].[continents] OFF
GO
SET IDENTITY_INSERT [dbo].[countries] ON 

INSERT [dbo].[countries] ([id], [code], [title], [continent_id]) VALUES (1, N'DE', N'Germany', 1)
INSERT [dbo].[countries] ([id], [code], [title], [continent_id]) VALUES (2, N'GR', N'Greece', 1)
INSERT [dbo].[countries] ([id], [code], [title], [continent_id]) VALUES (3, N'RU', N'Russia', 1)
INSERT [dbo].[countries] ([id], [code], [title], [continent_id]) VALUES (4, N'FR', N'France', 1)
INSERT [dbo].[countries] ([id], [code], [title], [continent_id]) VALUES (6, N'US', N'USA', 2)
SET IDENTITY_INSERT [dbo].[countries] OFF
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
SET IDENTITY_INSERT [dbo].[currency_rates] ON 

INSERT [dbo].[currency_rates] ([id], [fromCur], [toCur], [rate]) VALUES (1, N'EUR', N'DKK', CAST(67.56 AS Decimal(10, 2)))
INSERT [dbo].[currency_rates] ([id], [fromCur], [toCur], [rate]) VALUES (2, N'EUR', N'CHF', CAST(1.21 AS Decimal(10, 2)))
INSERT [dbo].[currency_rates] ([id], [fromCur], [toCur], [rate]) VALUES (3, N'EUR', N'SEK', CAST(75.00 AS Decimal(10, 2)))
INSERT [dbo].[currency_rates] ([id], [fromCur], [toCur], [rate]) VALUES (4, N'EUR', N'USD', CAST(1.67 AS Decimal(10, 2)))
SET IDENTITY_INSERT [dbo].[currency_rates] OFF
GO
SET IDENTITY_INSERT [dbo].[listings] ON 

INSERT [dbo].[listings] ([id], [selling_id], [currency_code], [price], [fee_euro], [active_from], [active_until], [num_watchers], [is_auction]) VALUES (1, 1, N'EUR', CAST(35.00 AS Decimal(10, 2)), CAST(2.00 AS Decimal(10, 2)), CAST(N'2020-11-01T00:00:00.000' AS DateTime), CAST(N'2020-12-05T00:00:00.000' AS DateTime), 5, 0)
SET IDENTITY_INSERT [dbo].[listings] OFF
GO
SET IDENTITY_INSERT [dbo].[order_item_track_history] ON 

INSERT [dbo].[order_item_track_history] ([id], [item_id], [status_id], [created_at]) VALUES (1, 1, 1, CAST(N'2020-11-15T12:45:34.000' AS DateTime))
SET IDENTITY_INSERT [dbo].[order_item_track_history] OFF
GO
SET IDENTITY_INSERT [dbo].[order_items] ON 

INSERT [dbo].[order_items] ([id], [order_id], [product_id], [seller_id], [quantity], [tracking_num], [total], [goods_total], [ship_total], [currency_code], [rate], [status_id], [is_void]) VALUES (1, 1, 1, 1, 1, NULL, CAST(45.00 AS Decimal(10, 2)), CAST(34.00 AS Decimal(10, 2)), CAST(12.00 AS Decimal(10, 2)), N'EUR', CAST(1.00 AS Decimal(10, 2)), 1, 0)
SET IDENTITY_INSERT [dbo].[order_items] OFF
GO
SET IDENTITY_INSERT [dbo].[order_status] ON 

INSERT [dbo].[order_status] ([id], [title]) VALUES (1, N'Pending')
INSERT [dbo].[order_status] ([id], [title]) VALUES (2, N'Processing')
INSERT [dbo].[order_status] ([id], [title]) VALUES (3, N'Dispatched')
INSERT [dbo].[order_status] ([id], [title]) VALUES (4, N'Received')
INSERT [dbo].[order_status] ([id], [title]) VALUES (5, N'Returning to seller')
INSERT [dbo].[order_status] ([id], [title]) VALUES (6, N'Seller received back')
SET IDENTITY_INSERT [dbo].[order_status] OFF
GO
SET IDENTITY_INSERT [dbo].[orders] ON 

INSERT [dbo].[orders] ([id], [user_id], [billing_address_id], [shipping_address_id], [payment_method_id], [bank_transaction_id], [total], [goods_total], [shipping_total], [fee], [currency_code], [success], [void], [refund], [created_at], [updated_at]) VALUES (1, 1, 1, 1, 1, N'GRKGIRT340003345XGW', CAST(56.00 AS Decimal(10, 2)), CAST(35.00 AS Decimal(10, 2)), CAST(5.00 AS Decimal(10, 2)), CAST(1.00 AS Decimal(10, 2)), N'EUR', 1, 0, 0, CAST(N'2020-11-15T12:45:34.000' AS DateTime), CAST(N'2020-11-15T12:45:47.000' AS DateTime))
SET IDENTITY_INSERT [dbo].[orders] OFF
GO
SET IDENTITY_INSERT [dbo].[payment_methods] ON 

INSERT [dbo].[payment_methods] ([id], [title]) VALUES (1, N'CreditCard')
INSERT [dbo].[payment_methods] ([id], [title]) VALUES (2, N'Paypal')
SET IDENTITY_INSERT [dbo].[payment_methods] OFF
GO
SET IDENTITY_INSERT [dbo].[product_categories] ON 

INSERT [dbo].[product_categories] ([id], [title]) VALUES (1, N'Books')
SET IDENTITY_INSERT [dbo].[product_categories] OFF
GO
SET IDENTITY_INSERT [dbo].[product_filters] ON 

INSERT [dbo].[product_filters] ([id], [product_category_id], [title]) VALUES (1, 1, N'Cover')
INSERT [dbo].[product_filters] ([id], [product_category_id], [title]) VALUES (3, 1, N'Language')
INSERT [dbo].[product_filters] ([id], [product_category_id], [title]) VALUES (4, 1, N'Pages')
INSERT [dbo].[product_filters] ([id], [product_category_id], [title]) VALUES (5, 1, N'ISBN')
INSERT [dbo].[product_filters] ([id], [product_category_id], [title]) VALUES (6, 1, N'Publication year')
INSERT [dbo].[product_filters] ([id], [product_category_id], [title]) VALUES (7, 1, N'Author')
INSERT [dbo].[product_filters] ([id], [product_category_id], [title]) VALUES (8, 1, N'Translatior')
SET IDENTITY_INSERT [dbo].[product_filters] OFF
GO
SET IDENTITY_INSERT [dbo].[products] ON 

INSERT [dbo].[products] ([id], [title], [other_title], [description], [category_id], [preowned], [weight], [dim_l], [dim_w], [dim_h]) VALUES (1, N'Harry Potter och halvblutprins', N'Harry Potter and the half blood prince', NULL, 1, 0, CAST(1.20 AS Decimal(5, 2)), CAST(35.00 AS Decimal(5, 2)), CAST(65.00 AS Decimal(5, 2)), CAST(22.00 AS Decimal(5, 2)))
SET IDENTITY_INSERT [dbo].[products] OFF
GO
SET IDENTITY_INSERT [dbo].[sellers] ON 

INSERT [dbo].[sellers] ([id], [user_id], [country_code], [title], [ssn], [avg_stars]) VALUES (1, 2, N'EUR', N'Happy Dear', N'54393355', CAST(4.99 AS Decimal(3, 2)))
SET IDENTITY_INSERT [dbo].[sellers] OFF
GO
SET IDENTITY_INSERT [dbo].[selling] ON 

INSERT [dbo].[selling] ([id], [seller_id], [product_id], [quantity], [mailer_company]) VALUES (1, 1, 1, 15, N'DHL')
SET IDENTITY_INSERT [dbo].[selling] OFF
GO
SET IDENTITY_INSERT [dbo].[shipping_address] ON 

INSERT [dbo].[shipping_address] ([id], [user_id], [country_code], [city], [region], [street], [street_no], [post_code], [surname], [name]) VALUES (1, 1, N'GR', N'Athens', N'Faliro', N'Pushkin', N'45', N'17935', N'Alex', N'Tolkien')
SET IDENTITY_INSERT [dbo].[shipping_address] OFF
GO
SET IDENTITY_INSERT [dbo].[shipping_costs] ON 

INSERT [dbo].[shipping_costs] ([id], [selling_id], [continent_code], [cost]) VALUES (2, 1, N'EU', CAST(12.00 AS Decimal(10, 2)))
SET IDENTITY_INSERT [dbo].[shipping_costs] OFF
GO
SET IDENTITY_INSERT [dbo].[shipping_costs_exceptions] ON 

INSERT [dbo].[shipping_costs_exceptions] ([id], [selling_id], [country_code], [cost]) VALUES (1, 1, N'GR', CAST(5.00 AS Decimal(10, 2)))
SET IDENTITY_INSERT [dbo].[shipping_costs_exceptions] OFF
GO
SET IDENTITY_INSERT [dbo].[shipping_country_forbidden] ON 

INSERT [dbo].[shipping_country_forbidden] ([id], [selling_id], [country_code]) VALUES (1, 1, N'CN')
SET IDENTITY_INSERT [dbo].[shipping_country_forbidden] OFF
GO
SET IDENTITY_INSERT [dbo].[users] ON 

INSERT [dbo].[users] ([id], [email]) VALUES (1, N'test')
INSERT [dbo].[users] ([id], [email]) VALUES (2, N'happydeer')
SET IDENTITY_INSERT [dbo].[users] OFF
GO
ALTER TABLE [dbo].[biddings]  WITH CHECK ADD  CONSTRAINT [FK_biddings_listings] FOREIGN KEY([listing_id])
REFERENCES [dbo].[listings] ([id])
GO
ALTER TABLE [dbo].[biddings] CHECK CONSTRAINT [FK_biddings_listings]
GO
ALTER TABLE [dbo].[biddings]  WITH CHECK ADD  CONSTRAINT [FK_biddings_users] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[biddings] CHECK CONSTRAINT [FK_biddings_users]
GO
ALTER TABLE [dbo].[billing_address]  WITH CHECK ADD  CONSTRAINT [FK_billing_address_users] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[billing_address] CHECK CONSTRAINT [FK_billing_address_users]
GO
ALTER TABLE [dbo].[countries]  WITH CHECK ADD  CONSTRAINT [FK_countries_continents] FOREIGN KEY([continent_id])
REFERENCES [dbo].[continents] ([id])
GO
ALTER TABLE [dbo].[countries] CHECK CONSTRAINT [FK_countries_continents]
GO
ALTER TABLE [dbo].[credit_cards]  WITH CHECK ADD  CONSTRAINT [FK_credit_cards_orders] FOREIGN KEY([order_id])
REFERENCES [dbo].[orders] ([id])
GO
ALTER TABLE [dbo].[credit_cards] CHECK CONSTRAINT [FK_credit_cards_orders]
GO
ALTER TABLE [dbo].[listing_watchers]  WITH CHECK ADD  CONSTRAINT [FK_listing_watchers_listings] FOREIGN KEY([listing_id])
REFERENCES [dbo].[listings] ([id])
GO
ALTER TABLE [dbo].[listing_watchers] CHECK CONSTRAINT [FK_listing_watchers_listings]
GO
ALTER TABLE [dbo].[listing_watchers]  WITH CHECK ADD  CONSTRAINT [FK_listing_watchers_users] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[listing_watchers] CHECK CONSTRAINT [FK_listing_watchers_users]
GO
ALTER TABLE [dbo].[listings]  WITH CHECK ADD  CONSTRAINT [FK_listings_selling] FOREIGN KEY([selling_id])
REFERENCES [dbo].[selling] ([id])
GO
ALTER TABLE [dbo].[listings] CHECK CONSTRAINT [FK_listings_selling]
GO
ALTER TABLE [dbo].[order_item_track_history]  WITH CHECK ADD  CONSTRAINT [FK_order_item_track_history_order_items] FOREIGN KEY([item_id])
REFERENCES [dbo].[order_items] ([id])
GO
ALTER TABLE [dbo].[order_item_track_history] CHECK CONSTRAINT [FK_order_item_track_history_order_items]
GO
ALTER TABLE [dbo].[order_item_track_history]  WITH CHECK ADD  CONSTRAINT [FK_order_item_track_history_order_status] FOREIGN KEY([status_id])
REFERENCES [dbo].[order_status] ([id])
GO
ALTER TABLE [dbo].[order_item_track_history] CHECK CONSTRAINT [FK_order_item_track_history_order_status]
GO
ALTER TABLE [dbo].[order_items]  WITH CHECK ADD  CONSTRAINT [FK_order_items_order_status] FOREIGN KEY([status_id])
REFERENCES [dbo].[order_status] ([id])
GO
ALTER TABLE [dbo].[order_items] CHECK CONSTRAINT [FK_order_items_order_status]
GO
ALTER TABLE [dbo].[order_items]  WITH CHECK ADD  CONSTRAINT [FK_order_items_orders] FOREIGN KEY([order_id])
REFERENCES [dbo].[orders] ([id])
GO
ALTER TABLE [dbo].[order_items] CHECK CONSTRAINT [FK_order_items_orders]
GO
ALTER TABLE [dbo].[order_items]  WITH CHECK ADD  CONSTRAINT [FK_order_items_products] FOREIGN KEY([product_id])
REFERENCES [dbo].[products] ([id])
GO
ALTER TABLE [dbo].[order_items] CHECK CONSTRAINT [FK_order_items_products]
GO
ALTER TABLE [dbo].[order_items]  WITH CHECK ADD  CONSTRAINT [FK_order_items_sellers] FOREIGN KEY([seller_id])
REFERENCES [dbo].[sellers] ([id])
GO
ALTER TABLE [dbo].[order_items] CHECK CONSTRAINT [FK_order_items_sellers]
GO
ALTER TABLE [dbo].[orders]  WITH CHECK ADD  CONSTRAINT [FK_orders_billing_address] FOREIGN KEY([billing_address_id])
REFERENCES [dbo].[billing_address] ([id])
GO
ALTER TABLE [dbo].[orders] CHECK CONSTRAINT [FK_orders_billing_address]
GO
ALTER TABLE [dbo].[orders]  WITH CHECK ADD  CONSTRAINT [FK_orders_payment_methods] FOREIGN KEY([payment_method_id])
REFERENCES [dbo].[payment_methods] ([id])
GO
ALTER TABLE [dbo].[orders] CHECK CONSTRAINT [FK_orders_payment_methods]
GO
ALTER TABLE [dbo].[orders]  WITH CHECK ADD  CONSTRAINT [FK_orders_shipping_address] FOREIGN KEY([shipping_address_id])
REFERENCES [dbo].[shipping_address] ([id])
GO
ALTER TABLE [dbo].[orders] CHECK CONSTRAINT [FK_orders_shipping_address]
GO
ALTER TABLE [dbo].[orders]  WITH CHECK ADD  CONSTRAINT [FK_orders_users] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[orders] CHECK CONSTRAINT [FK_orders_users]
GO
ALTER TABLE [dbo].[product_filter_values]  WITH CHECK ADD  CONSTRAINT [FK_product_filter_values_product_filters] FOREIGN KEY([filter_id])
REFERENCES [dbo].[product_filters] ([id])
GO
ALTER TABLE [dbo].[product_filter_values] CHECK CONSTRAINT [FK_product_filter_values_product_filters]
GO
ALTER TABLE [dbo].[product_filter_values]  WITH CHECK ADD  CONSTRAINT [FK_product_filter_values_products] FOREIGN KEY([product_id])
REFERENCES [dbo].[products] ([id])
GO
ALTER TABLE [dbo].[product_filter_values] CHECK CONSTRAINT [FK_product_filter_values_products]
GO
ALTER TABLE [dbo].[product_filters]  WITH CHECK ADD  CONSTRAINT [FK_product_filters_product_categories] FOREIGN KEY([product_category_id])
REFERENCES [dbo].[product_categories] ([id])
GO
ALTER TABLE [dbo].[product_filters] CHECK CONSTRAINT [FK_product_filters_product_categories]
GO
ALTER TABLE [dbo].[products]  WITH CHECK ADD  CONSTRAINT [FK_products_product_categories] FOREIGN KEY([category_id])
REFERENCES [dbo].[product_categories] ([id])
GO
ALTER TABLE [dbo].[products] CHECK CONSTRAINT [FK_products_product_categories]
GO
ALTER TABLE [dbo].[reviews]  WITH CHECK ADD  CONSTRAINT [FK_reviews_order_items] FOREIGN KEY([item_id])
REFERENCES [dbo].[order_items] ([id])
GO
ALTER TABLE [dbo].[reviews] CHECK CONSTRAINT [FK_reviews_order_items]
GO
ALTER TABLE [dbo].[reviews]  WITH CHECK ADD  CONSTRAINT [FK_reviews_users] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[reviews] CHECK CONSTRAINT [FK_reviews_users]
GO
ALTER TABLE [dbo].[seller_reviews]  WITH CHECK ADD  CONSTRAINT [FK_seller_reviews_orders] FOREIGN KEY([order_id])
REFERENCES [dbo].[orders] ([id])
GO
ALTER TABLE [dbo].[seller_reviews] CHECK CONSTRAINT [FK_seller_reviews_orders]
GO
ALTER TABLE [dbo].[seller_reviews]  WITH CHECK ADD  CONSTRAINT [FK_seller_reviews_seller_reviews2] FOREIGN KEY([id])
REFERENCES [dbo].[seller_reviews] ([id])
GO
ALTER TABLE [dbo].[seller_reviews] CHECK CONSTRAINT [FK_seller_reviews_seller_reviews2]
GO
ALTER TABLE [dbo].[seller_reviews]  WITH CHECK ADD  CONSTRAINT [FK_seller_reviews_users] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[seller_reviews] CHECK CONSTRAINT [FK_seller_reviews_users]
GO
ALTER TABLE [dbo].[seller_reviews_categories_eval]  WITH CHECK ADD  CONSTRAINT [FK_seller_reviews_categories_eval_reviews] FOREIGN KEY([review_id])
REFERENCES [dbo].[reviews] ([id])
GO
ALTER TABLE [dbo].[seller_reviews_categories_eval] CHECK CONSTRAINT [FK_seller_reviews_categories_eval_reviews]
GO
ALTER TABLE [dbo].[seller_reviews_categories_eval]  WITH CHECK ADD  CONSTRAINT [FK_seller_reviews_categories_eval_seller_review_categories] FOREIGN KEY([review_id])
REFERENCES [dbo].[seller_review_categories] ([id])
GO
ALTER TABLE [dbo].[seller_reviews_categories_eval] CHECK CONSTRAINT [FK_seller_reviews_categories_eval_seller_review_categories]
GO
ALTER TABLE [dbo].[sellers]  WITH CHECK ADD  CONSTRAINT [FK_sellers_users] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[sellers] CHECK CONSTRAINT [FK_sellers_users]
GO
ALTER TABLE [dbo].[selling]  WITH CHECK ADD  CONSTRAINT [FK_selling_products] FOREIGN KEY([product_id])
REFERENCES [dbo].[products] ([id])
GO
ALTER TABLE [dbo].[selling] CHECK CONSTRAINT [FK_selling_products]
GO
ALTER TABLE [dbo].[selling]  WITH CHECK ADD  CONSTRAINT [FK_selling_users] FOREIGN KEY([seller_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[selling] CHECK CONSTRAINT [FK_selling_users]
GO
ALTER TABLE [dbo].[shipping_address]  WITH CHECK ADD  CONSTRAINT [FK_shipping_address_users] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[shipping_address] CHECK CONSTRAINT [FK_shipping_address_users]
GO
ALTER TABLE [dbo].[shipping_costs]  WITH CHECK ADD  CONSTRAINT [FK_shipping_costs_selling] FOREIGN KEY([selling_id])
REFERENCES [dbo].[selling] ([id])
GO
ALTER TABLE [dbo].[shipping_costs] CHECK CONSTRAINT [FK_shipping_costs_selling]
GO
ALTER TABLE [dbo].[shipping_costs_exceptions]  WITH CHECK ADD  CONSTRAINT [FK_shipping_costs_exceptions_selling] FOREIGN KEY([selling_id])
REFERENCES [dbo].[selling] ([id])
GO
ALTER TABLE [dbo].[shipping_costs_exceptions] CHECK CONSTRAINT [FK_shipping_costs_exceptions_selling]
GO
ALTER TABLE [dbo].[shipping_country_forbidden]  WITH CHECK ADD  CONSTRAINT [FK_shipping_country_forbidden_selling] FOREIGN KEY([selling_id])
REFERENCES [dbo].[selling] ([id])
GO
ALTER TABLE [dbo].[shipping_country_forbidden] CHECK CONSTRAINT [FK_shipping_country_forbidden_selling]
GO
USE [master]
GO
ALTER DATABASE [pbaydb] SET  READ_WRITE 
GO
