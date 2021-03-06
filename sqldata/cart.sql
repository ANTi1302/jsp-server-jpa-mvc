SET IDENTITY_INSERT [dbo].[Catogory] ON 
INSERT [dbo].[Catogory] ([CatogoryID],[CatogoryName],[icon]) VALUES (1,'Gucci','')
INSERT [dbo].[Catogory] ([CatogoryID],[CatogoryName],[icon]) VALUES (2,'Chanel','')
INSERT [dbo].[Catogory] ([CatogoryID],[CatogoryName],[icon]) VALUES (3,'PoYo','')
INSERT [dbo].[Catogory] ([CatogoryID],[CatogoryName],[icon]) VALUES (4,'Fuma','')
INSERT [dbo].[Catogory] ([CatogoryID],[CatogoryName],[icon]) VALUES (5,'YSL','')
SET IDENTITY_INSERT [dbo].[Catogory] OFF

SET IDENTITY_INSERT [dbo].[Users] ON 
INSERT  [dbo].[Users]([UserID],[access_tokenID],[email],[isAdmin],[isSaller],[Password],[Username]) VALUES (1,'','',1,0,1234,'admin')
INSERT  [dbo].[Users]([UserID],[access_tokenID],[email],[isAdmin],[isSaller],[Password],[Username]) VALUES (2,'','',0,1,1234,'hung')
INSERT  [dbo].[Users]([UserID],[access_tokenID],[email],[isAdmin],[isSaller],[Password],[Username]) VALUES (3,'','',1,1,1234,'phan')
SET IDENTITY_INSERT [dbo].[Users] OFF




SET IDENTITY_INSERT [dbo].[product] ON 
INSERT [dbo].[product] ([ProductID],[amount],[Description],[imageLink],[Price],[ProductName],[CategoryID],[SellerID]) VALUES (1, 12, 'Heritage elements are reimagined with a contemporary twist throughout the Gucci Aria collection. 
The Jackie 1961 is reimagined as a rectangular tote with a soft, flexible structure. Taken from the archives, logo details such as the allover GG motif and the Web stripe deepen the accessorys connection to Guccis history. 
The mini bag is completed by a black leather trim and the lines signature gold-toned piston hardware.', '/template/img/bg-img/1.jpg',120.0000,'Dionysus GG super mini bag','1','1')
INSERT [dbo].[product] ([ProductID],[amount],[Description],[imageLink],[Price],[ProductName],[CategoryID],[SellerID]) VALUES (2,13, 'Heritage elements are reimagined with a contemporary twist throughout the Gucci Aria collection. 
The Jackie 1961 is reimagined as a rectangular tote with a soft, flexible structure. Taken from the archives, logo details such as the allover GG motif and the Web stripe deepen the accessorys connection to Guccis history. 
The mini bag is completed by a black leather trim and the lines signature gold-toned piston hardware.', '/template/img/bg-img/2.jpg', 160.0000,'Jackie 1961 mini shoulder bag','2','3')
INSERT [dbo].[product] ([ProductID],[amount],[Description],[imageLink],[Price],[ProductName],[CategoryID],[SellerID]) VALUES (3,21, 'Heritage elements are reimagined with a contemporary twist throughout the Gucci Aria collection. 
The Jackie 1961 is reimagined as a rectangular tote with a soft, flexible structure. Taken from the archives, logo details such as the allover GG motif and the Web stripe deepen the accessorys connection to Guccis history. 
The mini bag is completed by a black leather trim and the lines signature gold-toned piston hardware.', '/template/img/bg-img/3.jpg', 150.0000,'Ophidia mini GG bag','3','1')
INSERT [dbo].[product] ([ProductID],[amount],[Description],[imageLink],[Price],[ProductName],[CategoryID],[SellerID]) VALUES (4,15, 'Heritage elements are reimagined with a contemporary twist throughout the Gucci Aria collection. 
The Jackie 1961 is reimagined as a rectangular tote with a soft, flexible structure. Taken from the archives, logo details such as the allover GG motif and the Web stripe deepen the accessorys connection to Guccis history. 
The mini bag is completed by a black leather trim and the lines signature gold-toned piston hardware.', '/template/img/bg-img/4.jpg', 123.0000,'Ophidia medium tote with Web','4','1')
INSERT [dbo].[product] ([ProductID],[amount],[Description],[imageLink],[Price],[ProductName],[CategoryID],[SellerID]) VALUES (5,71, 'Heritage elements are reimagined with a contemporary twist throughout the Gucci Aria collection. 
The Jackie 1961 is reimagined as a rectangular tote with a soft, flexible structure. Taken from the archives, logo details such as the allover GG motif and the Web stripe deepen the accessorys connection to Guccis history. 
The mini bag is completed by a black leather trim and the lines signature gold-toned piston hardware.', '/template/img/bg-img/5.jpg', 200.0000,'Womens platform slide sandal','1','1')
INSERT [dbo].[product] ([ProductID],[amount],[Description],[imageLink],[Price],[ProductName],[CategoryID],[SellerID]) VALUES (6,51, 'Heritage elements are reimagined with a contemporary twist throughout the Gucci Aria collection. 
The Jackie 1961 is reimagined as a rectangular tote with a soft, flexible structure. Taken from the archives, logo details such as the allover GG motif and the Web stripe deepen the accessorys connection to Guccis history. 
The mini bag is completed by a black leather trim and the lines signature gold-toned piston hardware.', '/template/img/bg-img/6.jpg', 800.0000,'Womens slide sandal','5','3')
INSERT [dbo].[product] ([ProductID],[amount],[Description],[imageLink],[Price],[ProductName],[CategoryID],[SellerID]) VALUES (7,81, 'Heritage elements are reimagined with a contemporary twist throughout the Gucci Aria collection. 
The Jackie 1961 is reimagined as a rectangular tote with a soft, flexible structure. Taken from the archives, logo details such as the allover GG motif and the Web stripe deepen the accessorys connection to Guccis history. 
The mini bag is completed by a black leather trim and the lines signature gold-toned piston hardware.', '/template/img/bg-img/7.jpg', 1200.0000,'GG denim bucket hat','2','3')
INSERT [dbo].[product] ([ProductID],[amount],[Description],[imageLink],[Price],[ProductName],[CategoryID],[SellerID]) VALUES (8,16, 'Heritage elements are reimagined with a contemporary twist throughout the Gucci Aria collection. 
The Jackie 1961 is reimagined as a rectangular tote with a soft, flexible structure. Taken from the archives, logo details such as the allover GG motif and the Web stripe deepen the accessorys connection to Guccis history. 
The mini bag is completed by a black leather trim and the lines signature gold-toned piston hardware.', '/template/img/bg-img/8.jpg', 1300.0000,'GG denim hat','3','3')
INSERT [dbo].[product] ([ProductID],[amount],[Description],[imageLink],[Price],[ProductName],[CategoryID],[SellerID]) VALUES (9,17, 'Heritage elements are reimagined with a contemporary twist throughout the Gucci Aria collection. 
The Jackie 1961 is reimagined as a rectangular tote with a soft, flexible structure. Taken from the archives, logo details such as the allover GG motif and the Web stripe deepen the accessorys connection to Guccis history. 
The mini bag is completed by a black leather trim and the lines signature gold-toned piston hardware.', '/template/img/bg-img/9.jpg', 150.0000,'GG denim bucket hat 20-2x','5','1')
INSERT [dbo].[product] ([ProductID],[amount],[Description],[imageLink],[Price],[ProductName],[CategoryID],[SellerID]) VALUES (10,15, 'Heritage elements are reimagined with a contemporary twist throughout the Gucci Aria collection. 
The Jackie 1961 is reimagined as a rectangular tote with a soft, flexible structure. Taken from the archives, logo details such as the allover GG motif and the Web stripe deepen the accessorys connection to Guccis history. 
The mini bag is completed by a black leather trim and the lines signature gold-toned piston hardware.', '/template/img/bg-img/1.jpg', 1030.0000,'GG bucket','4','1')
INSERT [dbo].[product] ([ProductID],[amount],[Description],[imageLink],[Price],[ProductName],[CategoryID],[SellerID]) VALUES (11,17, 'Heritage elements are reimagined with a contemporary twist throughout the Gucci Aria collection. 
The Jackie 1961 is reimagined as a rectangular tote with a soft, flexible structure. Taken from the archives, logo details such as the allover GG motif and the Web stripe deepen the accessorys connection to Guccis history. 
The mini bag is completed by a black leather trim and the lines signature gold-toned piston hardware.', '/template/img/bg-img/2.jpg', 1400.0000,'GG bucket & Bag Oval','3','1')
INSERT [dbo].[product] ([ProductID],[amount],[Description],[imageLink],[Price],[ProductName],[CategoryID],[SellerID]) VALUES (12,21, 'Heritage elements are reimagined with a contemporary twist throughout the Gucci Aria collection. 
The Jackie 1961 is reimagined as a rectangular tote with a soft, flexible structure. Taken from the archives, logo details such as the allover GG motif and the Web stripe deepen the accessorys connection to Guccis history. 
The mini bag is completed by a black leather trim and the lines signature gold-toned piston hardware.', '/template/img/bg-img/3.jpg', 2100.0000,'Ophidia GG medium tote','3','3')
INSERT [dbo].[product] ([ProductID],[amount],[Description],[imageLink],[Price],[ProductName],[CategoryID],[SellerID]) VALUES (13,31, 'Heritage elements are reimagined with a contemporary twist throughout the Gucci Aria collection. 
The Jackie 1961 is reimagined as a rectangular tote with a soft, flexible structure. Taken from the archives, logo details such as the allover GG motif and the Web stripe deepen the accessorys connection to Guccis history. 
The mini bag is completed by a black leather trim and the lines signature gold-toned piston hardware.', '/template/img/bg-img/4.jpg', 8100.0000,'Ophidia GG medium','3','1')
INSERT [dbo].[product] ([ProductID],[amount],[Description],[imageLink],[Price],[ProductName],[CategoryID],[SellerID]) VALUES (14,81, 'Heritage elements are reimagined with a contemporary twist throughout the Gucci Aria collection. 
The Jackie 1961 is reimagined as a rectangular tote with a soft, flexible structure. Taken from the archives, logo details such as the allover GG motif and the Web stripe deepen the accessorys connection to Guccis history. 
The mini bag is completed by a black leather trim and the lines signature gold-toned piston hardware.', '/template/img/bg-img/5.jpg', 9100.0000,'Gucci Bag Oval enamel detail','2','3')
INSERT [dbo].[product] ([ProductID],[amount],[Description],[imageLink],[Price],[ProductName],[CategoryID],[SellerID]) VALUES (15,91, 'Heritage elements are reimagined with a contemporary twist throughout the Gucci Aria collection. 
The Jackie 1961 is reimagined as a rectangular tote with a soft, flexible structure. Taken from the archives, logo details such as the allover GG motif and the Web stripe deepen the accessorys connection to Guccis history. 
The mini bag is completed by a black leather trim and the lines signature gold-toned piston hardware.', '/template/img/bg-img/6.jpg', 1040.0000,'Black and ivory GG','4','3')
INSERT [dbo].[product] ([ProductID],[amount],[Description],[imageLink],[Price],[ProductName],[CategoryID],[SellerID]) VALUES (16,21, 'Heritage elements are reimagined with a contemporary twist throughout the Gucci Aria collection. 
The Jackie 1961 is reimagined as a rectangular tote with a soft, flexible structure. Taken from the archives, logo details such as the allover GG motif and the Web stripe deepen the accessorys connection to Guccis history. 
The mini bag is completed by a black leather trim and the lines signature gold-toned piston hardware.', '/template/img/bg-img/7.jpg', 1500.0000,'Ophidia mall GG bag','5','3')
INSERT [dbo].[product] ([ProductID],[amount],[Description],[imageLink],[Price],[ProductName],[CategoryID],[SellerID]) VALUES (17,10, 'Heritage elements are reimagined with a contemporary twist throughout the Gucci Aria collection. 
The Jackie 1961 is reimagined as a rectangular tote with a soft, flexible structure. Taken from the archives, logo details such as the allover GG motif and the Web stripe deepen the accessorys connection to Guccis history. 
The mini bag is completed by a black leather trim and the lines signature gold-toned piston hardware.', '/template/img/bg-img/8.jpg', 1200.0000,'Ophidia mini GG','4','3')
INSERT [dbo].[product] ([ProductID],[amount],[Description],[imageLink],[Price],[ProductName],[CategoryID],[SellerID]) VALUES (18,11, 'Heritage elements are reimagined with a contemporary twist throughout the Gucci Aria collection. 
The Jackie 1961 is reimagined as a rectangular tote with a soft, flexible structure. Taken from the archives, logo details such as the allover GG motif and the Web stripe deepen the accessorys connection to Guccis history. 
The mini bag is completed by a black leather trim and the lines signature gold-toned piston hardware.', '/template/img/bg-img/9.jpg', 3100.0000,'Ophidia mini GG bag 2022','1','1')
INSERT [dbo].[product] ([ProductID],[amount],[Description],[imageLink],[Price],[ProductName],[CategoryID],[SellerID]) VALUES (19,15, 'Heritage elements are reimagined with a contemporary twist throughout the Gucci Aria collection. 
The Jackie 1961 is reimagined as a rectangular tote with a soft, flexible structure. Taken from the archives, logo details such as the allover GG motif and the Web stripe deepen the accessorys connection to Guccis history. 
The mini bag is completed by a black leather trim and the lines signature gold-toned piston hardware.', '/template/img/bg-img/1.jpg', 1040.0000,'GG bucket hat 0-9z','1','1')
INSERT [dbo].[product] ([ProductID],[amount],[Description],[imageLink],[Price],[ProductName],[CategoryID],[SellerID]) VALUES (20,177, 'Heritage elements are reimagined with a contemporary twist throughout the Gucci Aria collection. 
The Jackie 1961 is reimagined as a rectangular tote with a soft, flexible structure. Taken from the archives, logo details such as the allover GG motif and the Web stripe deepen the accessorys connection to Guccis history. 
The mini bag is completed by a black leather trim and the lines signature gold-toned piston hardware.', '/template/img/bg-img/2.jpg', 1900.0000,'GG denim bucket hat 2022','3','1')


SET IDENTITY_INSERT [dbo].[product] OFF
