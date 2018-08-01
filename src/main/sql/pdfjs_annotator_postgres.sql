CREATE TABLE "annotation" ( "id" varchar(255)  NOT NULL,
						   "annotator_schema_version" varchar(255)  DEFAULT NULL, 
						   "consumer" varchar(255)  DEFAULT NULL,
						   "created" timestamp DEFAULT NULL, "quote" text , 
						   "end1" varchar(255)  DEFAULT NULL, "end_offset" int DEFAULT NULL,
						   "start1" varchar(255)  DEFAULT NULL, "start_offset" int DEFAULT NULL, 
						   "tags" bytea, "text" text , "updated" timestamp DEFAULT NULL,
						   "uri" varchar(2000)  DEFAULT NULL, "user1" varchar(255)  DEFAULT NULL, 
						   PRIMARY KEY ("id") ) ; 
						   