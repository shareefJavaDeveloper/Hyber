USE [master]
GO
/****** Object:  Database [Vendor]    Script Date: 31-12-2021 14:37:26 ******/
CREATE DATABASE [Vendor]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Vendor', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\Vendor.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Vendor_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\Vendor_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [Vendor] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Vendor].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Vendor] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Vendor] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Vendor] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Vendor] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Vendor] SET ARITHABORT OFF 
GO
ALTER DATABASE [Vendor] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Vendor] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Vendor] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Vendor] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Vendor] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Vendor] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Vendor] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Vendor] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Vendor] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Vendor] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Vendor] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Vendor] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Vendor] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Vendor] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Vendor] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Vendor] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Vendor] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Vendor] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Vendor] SET  MULTI_USER 
GO
ALTER DATABASE [Vendor] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Vendor] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Vendor] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Vendor] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Vendor] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Vendor] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [Vendor] SET QUERY_STORE = OFF
GO
USE [Vendor]
GO
/****** Object:  Table [dbo].[Vendor_Hist_Registration]    Script Date: 31-12-2021 14:37:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vendor_Hist_Registration](
	[vendorRegId] [int] NOT NULL,
	[password] [varchar](18) NOT NULL,
	[firstName] [varchar](20) NULL,
	[lastName] [varchar](20) NULL,
	[Gender] [varchar](10) NULL,
	[contactNumber] [bigint] NULL,
	[city] [varchar](20) NULL,
	[CountryCode] [varchar](5) NULL,
	[EmailId] [varchar](50) NOT NULL,
	[vendorStatus] [varchar](20) NULL,
 CONSTRAINT [PK_VENDOR_HIST_REGISTRATION] PRIMARY KEY CLUSTERED 
(
	[vendorRegId] ASC,
	[EmailId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Vendor_Login]    Script Date: 31-12-2021 14:37:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vendor_Login](
	[vendorRegId] [int] NOT NULL,
	[password] [varchar](18) NOT NULL,
	[EmailId] [varchar](50) NOT NULL,
 CONSTRAINT [PK_VENDOR_LOGIN] PRIMARY KEY CLUSTERED 
(
	[vendorRegId] ASC,
	[EmailId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Vendor_Registration]    Script Date: 31-12-2021 14:37:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vendor_Registration](
	[vendorRegId] [int] NOT NULL,
	[password] [varchar](18) NOT NULL,
	[firstName] [varchar](20) NULL,
	[lastName] [varchar](20) NULL,
	[Gender] [varchar](10) NULL,
	[contactNumber] [bigint] NULL,
	[city] [varchar](20) NULL,
	[CountryCode] [varchar](5) NULL,
	[EmailId] [varchar](50) NOT NULL,
	[vendorStatus] [varchar](20) NULL,
 CONSTRAINT [PK_VENDOR_REGISTRATION] PRIMARY KEY CLUSTERED 
(
	[vendorRegId] ASC,
	[EmailId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  StoredProcedure [dbo].[Vendor_Registration_Process]    Script Date: 31-12-2021 14:37:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Vendor_Registration_Process] (@VendorRegId INT)
AS
BEGIN
	DECLARE @chkAcceptedStatus varchar(20) = 'Accepted';
	BEGIN TRY
		BEGIN TRANSACTION
			
			IF @chkAcceptedStatus = (select vendorStatus from Vendor_Registration where vendorRegId = @VendorRegId)
			BEGIN
				DROP TABLE IF EXISTS #temp_Accepted_Vendor_Registration

				SELECT [vendorRegId],
					[password],
					[firstName],
					[lastName],
					[Gender],
					[contactNumber],
					[city],
					[CountryCode],
					[EmailId],
					[vendorStatus]
				INTO #temp_Accepted_Vendor_Registration
				FROM Vendor_Registration where vendorRegId = @VendorRegId

				INSERT INTO [Vendor_Hist_Registration]
					SELECT * FROM #temp_Accepted_Vendor_Registration

				INSERT INTO [Vendor_Login]
					SELECT [vendorRegId],
						   [password],
						   [EmailId]
					FROM #temp_Accepted_Vendor_Registration

				DELETE FROM [Vendor_Registration]
					WHERE vendorRegId = @VendorRegId

				DROP TABLE #temp_Accepted_Vendor_Registration
			END

			ELSE

			BEGIN
				SELECT [vendorRegId],
					[password],
					[firstName],
					[lastName],
					[Gender],
					[contactNumber],
					[city],
					[CountryCode],
					[EmailId],
					[vendorStatus]
				INTO #temp_Rejected_Vendor_Registration
				FROM Vendor_Registration where vendorRegId = @VendorRegId

				INSERT INTO [Vendor_Hist_Registration]
					SELECT * FROM #temp_Rejected_Vendor_Registration

				DELETE FROM [Vendor_Registration]
					WHERE vendorRegId = @VendorRegId

				DROP TABLE #temp_Rejected_Vendor_Registration
			END
		COMMIT TRANSACTION
	END TRY
	BEGIN CATCH
		IF @@TRANCOUNT > 0
		BEGIN
			ROLLBACK TRANSACTION
		END;
		DECLARE @Message varchar(MAX) = ERROR_MESSAGE() + ' , rolled back ';
		THROW 50006, @Message ,1
	END CATCH
END
GO
USE [master]
GO
ALTER DATABASE [Vendor] SET  READ_WRITE 
GO
