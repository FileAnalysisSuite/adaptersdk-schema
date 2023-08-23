﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------
// This file is auto-generated by SchemaGenerator
namespace MicroFocus.FAS.AdapterSdkSchema
{
    public static class AdapterSdkSchema
    {
        public static readonly AccountsField ACCOUNTS = new AccountsField();
        public static readonly IField ADDRESS_BCC = new FieldImpl("ADDRESS_BCC", "STRING", null, true, false, false, false);
        public static readonly IField ADDRESS_CC = new FieldImpl("ADDRESS_CC", "STRING", null, true, false, false, false);
        public static readonly IField ADDRESS_DISPLAY_BCC = new FieldImpl("ADDRESS_DISPLAY_BCC", "FULLTEXT", null, true, false, true, false);
        public static readonly IField ADDRESS_DISPLAY_CC = new FieldImpl("ADDRESS_DISPLAY_CC", "FULLTEXT", null, true, false, true, false);
        public static readonly IField ADDRESS_DISPLAY_FROM = new FieldImpl("ADDRESS_DISPLAY_FROM", "FULLTEXT", null, false, false, true, false);
        public static readonly IField ADDRESS_DISPLAY_TO = new FieldImpl("ADDRESS_DISPLAY_TO", "FULLTEXT", null, true, false, true, false);
        public static readonly IField ADDRESS_FROM = new FieldImpl("ADDRESS_FROM", "STRING", null, false, false, false, false);
        public static readonly IField ADDRESS_TO = new FieldImpl("ADDRESS_TO", "STRING", null, true, false, false, false);
        public static readonly IField CC = new FieldImpl("CC", "STRING", null, false, false, false, false);
        public static readonly ColumnsField COLUMNS = new ColumnsField();
        public static readonly IField COLUMN_COUNT = new FieldImpl("COLUMN_COUNT", "INTEGER", null, false, false, false, false);
        public static readonly IField CONTENT_PRIMARY = new FieldImpl("CONTENT_PRIMARY", "FULLTEXT", null, false, false, true, false);
        public static readonly IField DATE_ARCHIVED = new FieldImpl("DATE_ARCHIVED", "DATETIME", null, false, false, false, false);
        public static readonly IField DATE_CREATED = new FieldImpl("DATE_CREATED", "DATETIME", null, false, false, false, false);
        public static readonly IField DATE_MODIFIED = new FieldImpl("DATE_MODIFIED", "DATETIME", null, false, false, false, false);
        public static readonly IField DATE_POSTED = new FieldImpl("DATE_POSTED", "DATETIME", null, false, false, false, false);
        public static readonly IField DIRECTION = new FieldImpl("DIRECTION", "STRING", null, false, false, false, false);
        public static readonly IField EXTRACTION_INDEX = new FieldImpl("EXTRACTION_INDEX", "STRING", null, false, false, false, false);
        public static readonly IField EXTRACTION_TYPE = new FieldImpl("EXTRACTION_TYPE", "STRING", null, false, false, false, false);
        public static readonly IField FAMILY_ADDRESS_BCC = new FieldImpl("FAMILY_ADDRESS_BCC", "STRING", null, true, false, false, false);
        public static readonly IField FAMILY_ADDRESS_CC = new FieldImpl("FAMILY_ADDRESS_CC", "STRING", null, true, false, false, false);
        public static readonly IField FAMILY_ADDRESS_DISPLAY_BCC = new FieldImpl("FAMILY_ADDRESS_DISPLAY_BCC", "FULLTEXT", null, true, false, true, false);
        public static readonly IField FAMILY_ADDRESS_DISPLAY_CC = new FieldImpl("FAMILY_ADDRESS_DISPLAY_CC", "FULLTEXT", null, true, false, true, false);
        public static readonly IField FAMILY_ADDRESS_DISPLAY_FROM = new FieldImpl("FAMILY_ADDRESS_DISPLAY_FROM", "FULLTEXT", null, false, false, true, false);
        public static readonly IField FAMILY_ADDRESS_DISPLAY_TO = new FieldImpl("FAMILY_ADDRESS_DISPLAY_TO", "FULLTEXT", null, true, false, true, false);
        public static readonly IField FAMILY_ADDRESS_FROM = new FieldImpl("FAMILY_ADDRESS_FROM", "STRING", null, false, false, false, false);
        public static readonly IField FAMILY_ADDRESS_TO = new FieldImpl("FAMILY_ADDRESS_TO", "STRING", null, true, false, false, false);
        public static readonly IField FAMILY_DATE_POSTED = new FieldImpl("FAMILY_DATE_POSTED", "DATETIME", null, false, false, false, false);
        public static readonly IField FAMILY_THREAD_TOPIC = new FieldImpl("FAMILY_THREAD_TOPIC", "STRING", null, false, false, false, false);
        public static readonly IField FAMILY_TITLE = new FieldImpl("FAMILY_TITLE", "FULLTEXT", null, false, false, true, false);
        public static readonly IField FILE_EXT = new FieldImpl("FILE_EXT", "STRING", null, false, false, true, false);
        public static readonly IField FILE_NAME = new FieldImpl("FILE_NAME", "STRING", null, false, true, true, false);
        public static readonly IField FILE_SIZE = new FieldImpl("FILE_SIZE", "LONG", null, false, false, false, false);
        public static readonly IField FILEPATH = new FieldImpl("FILEPATH", "STRING", null, false, false, true, true);
        public static readonly IField FROM = new FieldImpl("FROM", "STRING", null, false, false, false, false);
        public static readonly IField HAS_ATTACHMENTS = new FieldImpl("HAS_ATTACHMENTS", "BOOLEAN", null, false, false, false, false);
        public static readonly IField HASH = new FieldImpl("HASH", "STRING", null, false, true, false, false);
        public static readonly IField IS_OLE = new FieldImpl("IS_OLE", "BOOLEAN", null, false, false, false, false);
        public static readonly IField MESSAGE_ID = new FieldImpl("MESSAGE_ID", "STRING", null, false, false, false, false);
        public static readonly MetadataFilesField METADATA_FILES = new MetadataFilesField();
        public static readonly IField MIMETYPE = new FieldImpl("MIMETYPE", "STRING", null, false, true, true, false);
        public static readonly OcrField OCR = new OcrField();
        public static readonly IField PARENT_REFERENCE = new FieldImpl("PARENT_REFERENCE", "STRING", null, false, false, false, false);
        public static readonly IField PRIORITY = new FieldImpl("PRIORITY", "LONG", null, false, false, false, false);
        public static readonly IField REPO_CLASSIFICATION = new FieldImpl("REPO_CLASSIFICATION", "STRING", null, true, false, false, false);
        public static readonly IField REPO_EXPANDEDNUMBER = new FieldImpl("REPO_EXPANDEDNUMBER", "STRING", null, false, false, false, false);
        public static readonly IField REPO_FOLDER = new FieldImpl("REPO_FOLDER", "STRING", null, false, false, true, false);
        public static readonly IField REPO_LABELS = new FieldImpl("REPO_LABELS", "STRING", null, true, false, true, false);
        public static readonly IField REPO_NOTES = new FieldImpl("REPO_NOTES", "STRING", null, false, false, true, false);
        public static readonly IField REPO_RECORDNUMBER = new FieldImpl("REPO_RECORDNUMBER", "STRING", null, false, false, false, false);
        public static readonly IField REPO_RECORDTYPE = new FieldImpl("REPO_RECORDTYPE", "STRING", null, false, false, false, false);
        public static readonly IField REPO_URI = new FieldImpl("REPO_URI", "LONG", null, false, false, false, false);
        public static readonly IField ROOT_DATE_MODIFIED = new FieldImpl("ROOT_DATE_MODIFIED", "DATETIME", null, false, false, false, false);
        public static readonly IField ROOT_FILE_EXT = new FieldImpl("ROOT_FILE_EXT", "STRING", null, false, false, true, false);
        public static readonly IField ROOT_FILEPATH = new FieldImpl("ROOT_FILEPATH", "FULLTEXT", null, false, false, false, false);
        public static readonly IField ROOT_FILE_SIZE = new FieldImpl("ROOT_FILE_SIZE", "LONG", null, false, false, false, false);
        public static readonly IField ROOT_REPO_CLASSIFICATION = new FieldImpl("ROOT_REPO_CLASSIFICATION", "STRING", null, true, false, true, false);
        public static readonly IField ROOT_REPO_RECORDTYPE = new FieldImpl("ROOT_REPO_RECORDTYPE", "STRING", null, false, false, true, false);
        public static readonly IField ROW_COUNT = new FieldImpl("ROW_COUNT", "LONG", null, false, false, false, false);
        public static readonly IField SCAN_REFERENCE = new FieldImpl("SCAN_REFERENCE", "STRING", null, false, false, false, false);
        public static readonly IField SOURCE_REFERENCE = new FieldImpl("SOURCE_REFERENCE", "STRING", null, false, false, false, false);
        public static readonly IField TABLE_TYPE = new FieldImpl("TABLE_TYPE", "STRING", null, false, false, false, false);
        public static readonly IField THREAD_INDEX = new FieldImpl("THREAD_INDEX", "STRING", null, false, false, false, false);
        public static readonly IField THREAD_REPLY_TO = new FieldImpl("THREAD_REPLY_TO", "STRING", null, false, false, false, false);
        public static readonly IField THREAD_TOPIC = new FieldImpl("THREAD_TOPIC", "STRING", null, false, false, false, false);
        public static readonly IField TITLE = new FieldImpl("TITLE", "FULLTEXT", null, false, true, true, false);
        public static readonly IField TO = new FieldImpl("TO", "STRING", null, false, false, false, false);
        public static readonly IField TYPE = new FieldImpl("TYPE", "STRING", null, false, true, false, false);
        public static readonly IField UNIQUE_ID = new FieldImpl("UNIQUE_ID", "STRING", null, false, false, false, false);
        public static IField GetField(string fieldName)
        {
            switch (fieldName)
            {
                case "ACCOUNTS":
                    return ACCOUNTS;
                case "ACCOUNTS.DISPLAY_NAME":
                    return ACCOUNTS.DISPLAY_NAME;
                case "ACCOUNTS.HANDLES":
                    return ACCOUNTS.HANDLES;
                case "ACCOUNTS.IDENTIFIER":
                    return ACCOUNTS.IDENTIFIER;
                case "ACCOUNTS.IDENTIFIER_TYPE":
                    return ACCOUNTS.IDENTIFIER_TYPE;
                case "ACCOUNTS.SENDER":
                    return ACCOUNTS.SENDER;
                case "ADDRESS_BCC":
                    return ADDRESS_BCC;
                case "ADDRESS_CC":
                    return ADDRESS_CC;
                case "ADDRESS_DISPLAY_BCC":
                    return ADDRESS_DISPLAY_BCC;
                case "ADDRESS_DISPLAY_CC":
                    return ADDRESS_DISPLAY_CC;
                case "ADDRESS_DISPLAY_FROM":
                    return ADDRESS_DISPLAY_FROM;
                case "ADDRESS_DISPLAY_TO":
                    return ADDRESS_DISPLAY_TO;
                case "ADDRESS_FROM":
                    return ADDRESS_FROM;
                case "ADDRESS_TO":
                    return ADDRESS_TO;
                case "CC":
                    return CC;
                case "COLUMNS":
                    return COLUMNS;
                case "COLUMNS.GRAMMAR_MATCHES":
                    return COLUMNS.GRAMMAR_MATCHES;
                case "COLUMNS.GRAMMAR_MATCHES.RULES":
                    return COLUMNS.GRAMMAR_MATCHES.RULES;
                case "COLUMNS.GRAMMAR_MATCHES.WEIGHT":
                    return COLUMNS.GRAMMAR_MATCHES.WEIGHT;
                case "COLUMNS.NAME":
                    return COLUMNS.NAME;
                case "COLUMNS.REVIEWED_BY":
                    return COLUMNS.REVIEWED_BY;
                case "COLUMNS.REVIEWER_COMMENTS":
                    return COLUMNS.REVIEWER_COMMENTS;
                case "COLUMNS.SELECTED_GRAMMAR_RULE":
                    return COLUMNS.SELECTED_GRAMMAR_RULE;
                case "COLUMNS.STATUS":
                    return COLUMNS.STATUS;
                case "COLUMNS.TYPE":
                    return COLUMNS.TYPE;
                case "COLUMN_COUNT":
                    return COLUMN_COUNT;
                case "CONTENT_PRIMARY":
                    return CONTENT_PRIMARY;
                case "DATE_ARCHIVED":
                    return DATE_ARCHIVED;
                case "DATE_CREATED":
                    return DATE_CREATED;
                case "DATE_MODIFIED":
                    return DATE_MODIFIED;
                case "DATE_POSTED":
                    return DATE_POSTED;
                case "DIRECTION":
                    return DIRECTION;
                case "EXTRACTION_INDEX":
                    return EXTRACTION_INDEX;
                case "EXTRACTION_TYPE":
                    return EXTRACTION_TYPE;
                case "FAMILY_ADDRESS_BCC":
                    return FAMILY_ADDRESS_BCC;
                case "FAMILY_ADDRESS_CC":
                    return FAMILY_ADDRESS_CC;
                case "FAMILY_ADDRESS_DISPLAY_BCC":
                    return FAMILY_ADDRESS_DISPLAY_BCC;
                case "FAMILY_ADDRESS_DISPLAY_CC":
                    return FAMILY_ADDRESS_DISPLAY_CC;
                case "FAMILY_ADDRESS_DISPLAY_FROM":
                    return FAMILY_ADDRESS_DISPLAY_FROM;
                case "FAMILY_ADDRESS_DISPLAY_TO":
                    return FAMILY_ADDRESS_DISPLAY_TO;
                case "FAMILY_ADDRESS_FROM":
                    return FAMILY_ADDRESS_FROM;
                case "FAMILY_ADDRESS_TO":
                    return FAMILY_ADDRESS_TO;
                case "FAMILY_DATE_POSTED":
                    return FAMILY_DATE_POSTED;
                case "FAMILY_THREAD_TOPIC":
                    return FAMILY_THREAD_TOPIC;
                case "FAMILY_TITLE":
                    return FAMILY_TITLE;
                case "FILE_EXT":
                    return FILE_EXT;
                case "FILE_NAME":
                    return FILE_NAME;
                case "FILE_SIZE":
                    return FILE_SIZE;
                case "FILEPATH":
                    return FILEPATH;
                case "FROM":
                    return FROM;
                case "HAS_ATTACHMENTS":
                    return HAS_ATTACHMENTS;
                case "HASH":
                    return HASH;
                case "IS_OLE":
                    return IS_OLE;
                case "MESSAGE_ID":
                    return MESSAGE_ID;
                case "METADATA_FILES":
                    return METADATA_FILES;
                case "METADATA_FILES.CONTENT":
                    return METADATA_FILES.CONTENT;
                case "METADATA_FILES.EXTENSION":
                    return METADATA_FILES.EXTENSION;
                case "MIMETYPE":
                    return MIMETYPE;
                case "OCR":
                    return OCR;
                case "OCR.CONFIDENCE":
                    return OCR.CONFIDENCE;
                case "OCR.NAME":
                    return OCR.NAME;
                case "OCR.TYPE":
                    return OCR.TYPE;
                case "OCR.VALUE":
                    return OCR.VALUE;
                case "PARENT_REFERENCE":
                    return PARENT_REFERENCE;
                case "PRIORITY":
                    return PRIORITY;
                case "REPO_CLASSIFICATION":
                    return REPO_CLASSIFICATION;
                case "REPO_EXPANDEDNUMBER":
                    return REPO_EXPANDEDNUMBER;
                case "REPO_FOLDER":
                    return REPO_FOLDER;
                case "REPO_LABELS":
                    return REPO_LABELS;
                case "REPO_NOTES":
                    return REPO_NOTES;
                case "REPO_RECORDNUMBER":
                    return REPO_RECORDNUMBER;
                case "REPO_RECORDTYPE":
                    return REPO_RECORDTYPE;
                case "REPO_URI":
                    return REPO_URI;
                case "ROOT_DATE_MODIFIED":
                    return ROOT_DATE_MODIFIED;
                case "ROOT_FILE_EXT":
                    return ROOT_FILE_EXT;
                case "ROOT_FILEPATH":
                    return ROOT_FILEPATH;
                case "ROOT_FILE_SIZE":
                    return ROOT_FILE_SIZE;
                case "ROOT_REPO_CLASSIFICATION":
                    return ROOT_REPO_CLASSIFICATION;
                case "ROOT_REPO_RECORDTYPE":
                    return ROOT_REPO_RECORDTYPE;
                case "ROW_COUNT":
                    return ROW_COUNT;
                case "SCAN_REFERENCE":
                    return SCAN_REFERENCE;
                case "SOURCE_REFERENCE":
                    return SOURCE_REFERENCE;
                case "TABLE_TYPE":
                    return TABLE_TYPE;
                case "THREAD_INDEX":
                    return THREAD_INDEX;
                case "THREAD_REPLY_TO":
                    return THREAD_REPLY_TO;
                case "THREAD_TOPIC":
                    return THREAD_TOPIC;
                case "TITLE":
                    return TITLE;
                case "TO":
                    return TO;
                case "TYPE":
                    return TYPE;
                case "UNIQUE_ID":
                    return UNIQUE_ID;
                default:
                    throw new FieldNotFoundException(fieldName);
            }
        }

        public static IField GetField(string fieldName, bool ignoreCase)
        {
            if (!ignoreCase)
            {
                return GetField(fieldName);
            }

            switch (fieldName.ToUpperInvariant())
            {
                case "ACCOUNTS":
                    return ACCOUNTS;
                case "ACCOUNTS.DISPLAY_NAME":
                    return ACCOUNTS.DISPLAY_NAME;
                case "ACCOUNTS.HANDLES":
                    return ACCOUNTS.HANDLES;
                case "ACCOUNTS.IDENTIFIER":
                    return ACCOUNTS.IDENTIFIER;
                case "ACCOUNTS.IDENTIFIER_TYPE":
                    return ACCOUNTS.IDENTIFIER_TYPE;
                case "ACCOUNTS.SENDER":
                    return ACCOUNTS.SENDER;
                case "ADDRESS_BCC":
                    return ADDRESS_BCC;
                case "ADDRESS_CC":
                    return ADDRESS_CC;
                case "ADDRESS_DISPLAY_BCC":
                    return ADDRESS_DISPLAY_BCC;
                case "ADDRESS_DISPLAY_CC":
                    return ADDRESS_DISPLAY_CC;
                case "ADDRESS_DISPLAY_FROM":
                    return ADDRESS_DISPLAY_FROM;
                case "ADDRESS_DISPLAY_TO":
                    return ADDRESS_DISPLAY_TO;
                case "ADDRESS_FROM":
                    return ADDRESS_FROM;
                case "ADDRESS_TO":
                    return ADDRESS_TO;
                case "CC":
                    return CC;
                case "COLUMNS":
                    return COLUMNS;
                case "COLUMNS.GRAMMAR_MATCHES":
                    return COLUMNS.GRAMMAR_MATCHES;
                case "COLUMNS.GRAMMAR_MATCHES.RULES":
                    return COLUMNS.GRAMMAR_MATCHES.RULES;
                case "COLUMNS.GRAMMAR_MATCHES.WEIGHT":
                    return COLUMNS.GRAMMAR_MATCHES.WEIGHT;
                case "COLUMNS.NAME":
                    return COLUMNS.NAME;
                case "COLUMNS.REVIEWED_BY":
                    return COLUMNS.REVIEWED_BY;
                case "COLUMNS.REVIEWER_COMMENTS":
                    return COLUMNS.REVIEWER_COMMENTS;
                case "COLUMNS.SELECTED_GRAMMAR_RULE":
                    return COLUMNS.SELECTED_GRAMMAR_RULE;
                case "COLUMNS.STATUS":
                    return COLUMNS.STATUS;
                case "COLUMNS.TYPE":
                    return COLUMNS.TYPE;
                case "COLUMN_COUNT":
                    return COLUMN_COUNT;
                case "CONTENT_PRIMARY":
                    return CONTENT_PRIMARY;
                case "DATE_ARCHIVED":
                    return DATE_ARCHIVED;
                case "DATE_CREATED":
                    return DATE_CREATED;
                case "DATE_MODIFIED":
                    return DATE_MODIFIED;
                case "DATE_POSTED":
                    return DATE_POSTED;
                case "DIRECTION":
                    return DIRECTION;
                case "EXTRACTION_INDEX":
                    return EXTRACTION_INDEX;
                case "EXTRACTION_TYPE":
                    return EXTRACTION_TYPE;
                case "FAMILY_ADDRESS_BCC":
                    return FAMILY_ADDRESS_BCC;
                case "FAMILY_ADDRESS_CC":
                    return FAMILY_ADDRESS_CC;
                case "FAMILY_ADDRESS_DISPLAY_BCC":
                    return FAMILY_ADDRESS_DISPLAY_BCC;
                case "FAMILY_ADDRESS_DISPLAY_CC":
                    return FAMILY_ADDRESS_DISPLAY_CC;
                case "FAMILY_ADDRESS_DISPLAY_FROM":
                    return FAMILY_ADDRESS_DISPLAY_FROM;
                case "FAMILY_ADDRESS_DISPLAY_TO":
                    return FAMILY_ADDRESS_DISPLAY_TO;
                case "FAMILY_ADDRESS_FROM":
                    return FAMILY_ADDRESS_FROM;
                case "FAMILY_ADDRESS_TO":
                    return FAMILY_ADDRESS_TO;
                case "FAMILY_DATE_POSTED":
                    return FAMILY_DATE_POSTED;
                case "FAMILY_THREAD_TOPIC":
                    return FAMILY_THREAD_TOPIC;
                case "FAMILY_TITLE":
                    return FAMILY_TITLE;
                case "FILE_EXT":
                    return FILE_EXT;
                case "FILE_NAME":
                    return FILE_NAME;
                case "FILE_SIZE":
                    return FILE_SIZE;
                case "FILEPATH":
                    return FILEPATH;
                case "FROM":
                    return FROM;
                case "HAS_ATTACHMENTS":
                    return HAS_ATTACHMENTS;
                case "HASH":
                    return HASH;
                case "IS_OLE":
                    return IS_OLE;
                case "MESSAGE_ID":
                    return MESSAGE_ID;
                case "METADATA_FILES":
                    return METADATA_FILES;
                case "METADATA_FILES.CONTENT":
                    return METADATA_FILES.CONTENT;
                case "METADATA_FILES.EXTENSION":
                    return METADATA_FILES.EXTENSION;
                case "MIMETYPE":
                    return MIMETYPE;
                case "OCR":
                    return OCR;
                case "OCR.CONFIDENCE":
                    return OCR.CONFIDENCE;
                case "OCR.NAME":
                    return OCR.NAME;
                case "OCR.TYPE":
                    return OCR.TYPE;
                case "OCR.VALUE":
                    return OCR.VALUE;
                case "PARENT_REFERENCE":
                    return PARENT_REFERENCE;
                case "PRIORITY":
                    return PRIORITY;
                case "REPO_CLASSIFICATION":
                    return REPO_CLASSIFICATION;
                case "REPO_EXPANDEDNUMBER":
                    return REPO_EXPANDEDNUMBER;
                case "REPO_FOLDER":
                    return REPO_FOLDER;
                case "REPO_LABELS":
                    return REPO_LABELS;
                case "REPO_NOTES":
                    return REPO_NOTES;
                case "REPO_RECORDNUMBER":
                    return REPO_RECORDNUMBER;
                case "REPO_RECORDTYPE":
                    return REPO_RECORDTYPE;
                case "REPO_URI":
                    return REPO_URI;
                case "ROOT_DATE_MODIFIED":
                    return ROOT_DATE_MODIFIED;
                case "ROOT_FILE_EXT":
                    return ROOT_FILE_EXT;
                case "ROOT_FILEPATH":
                    return ROOT_FILEPATH;
                case "ROOT_FILE_SIZE":
                    return ROOT_FILE_SIZE;
                case "ROOT_REPO_CLASSIFICATION":
                    return ROOT_REPO_CLASSIFICATION;
                case "ROOT_REPO_RECORDTYPE":
                    return ROOT_REPO_RECORDTYPE;
                case "ROW_COUNT":
                    return ROW_COUNT;
                case "SCAN_REFERENCE":
                    return SCAN_REFERENCE;
                case "SOURCE_REFERENCE":
                    return SOURCE_REFERENCE;
                case "TABLE_TYPE":
                    return TABLE_TYPE;
                case "THREAD_INDEX":
                    return THREAD_INDEX;
                case "THREAD_REPLY_TO":
                    return THREAD_REPLY_TO;
                case "THREAD_TOPIC":
                    return THREAD_TOPIC;
                case "TITLE":
                    return TITLE;
                case "TO":
                    return TO;
                case "TYPE":
                    return TYPE;
                case "UNIQUE_ID":
                    return UNIQUE_ID;
                default:
                    throw new FieldNotFoundException(fieldName);
            }
        }

        public class AccountsField : IStructuredField
        {
            private readonly IField field;
            public readonly ISubfield DISPLAY_NAME;
            public readonly ISubfield HANDLES;
            public readonly ISubfield IDENTIFIER;
            public readonly ISubfield IDENTIFIER_TYPE;
            public readonly ISubfield SENDER;
            public string FieldName => field.FieldName;
            public string FieldType => field.FieldType;
            public ObjectEncoding? ObjectEncoding => field.ObjectEncoding;
            public IField ParentField => field.ParentField;
            public bool IsMultivalue => field.IsMultivalue;
            public bool IsMandatory => field.IsMandatory;
            public bool IsCaseInsensitive => field.IsCaseInsensitive;
            public bool IsTokenizedPath => field.IsTokenizedPath;
            internal AccountsField()
            {
                this.field = new FieldImpl("ACCOUNTS", "person", MicroFocus.FAS.AdapterSdkSchema.ObjectEncoding.Json, true, false, false, false);
                this.DISPLAY_NAME = new SubfieldImpl("DISPLAY_NAME", "FULLTEXT", null, false, false, true, false, this);
                this.HANDLES = new SubfieldImpl("HANDLES", "FULLTEXT", null, true, false, true, false, this);
                this.IDENTIFIER = new SubfieldImpl("IDENTIFIER", "FULLTEXT", null, false, false, true, false, this);
                this.IDENTIFIER_TYPE = new SubfieldImpl("IDENTIFIER_TYPE", "FULLTEXT", null, false, false, true, false, this);
                this.SENDER = new SubfieldImpl("SENDER", "BOOLEAN", null, false, false, false, false, this);
            }
        }

        public class ColumnsField : IStructuredField
        {
            private readonly IField field;
            public readonly ColumnsField.GrammarMatchesField GRAMMAR_MATCHES = new ColumnsField.GrammarMatchesField();
            public readonly ISubfield NAME;
            public readonly ISubfield REVIEWED_BY;
            public readonly ISubfield REVIEWER_COMMENTS;
            public readonly ISubfield SELECTED_GRAMMAR_RULE;
            public readonly ISubfield STATUS;
            public readonly ISubfield TYPE;
            public string FieldName => field.FieldName;
            public string FieldType => field.FieldType;
            public ObjectEncoding? ObjectEncoding => field.ObjectEncoding;
            public IField ParentField => field.ParentField;
            public bool IsMultivalue => field.IsMultivalue;
            public bool IsMandatory => field.IsMandatory;
            public bool IsCaseInsensitive => field.IsCaseInsensitive;
            public bool IsTokenizedPath => field.IsTokenizedPath;
            internal ColumnsField()
            {
                this.field = new FieldImpl("COLUMNS", "columns", MicroFocus.FAS.AdapterSdkSchema.ObjectEncoding.Json, true, false, false, false);
                this.NAME = new SubfieldImpl("NAME", "STRING", null, false, false, false, false, this);
                this.REVIEWED_BY = new SubfieldImpl("REVIEWED_BY", "FULLTEXT", null, false, false, true, false, this);
                this.REVIEWER_COMMENTS = new SubfieldImpl("REVIEWER_COMMENTS", "FULLTEXT", null, false, false, true, false, this);
                this.SELECTED_GRAMMAR_RULE = new SubfieldImpl("SELECTED_GRAMMAR_RULE", "STRING", null, false, false, false, false, this);
                this.STATUS = new SubfieldImpl("STATUS", "STRING", null, false, false, false, false, this);
                this.TYPE = new SubfieldImpl("TYPE", "STRING", null, false, false, false, false, this);
            }

            public class GrammarMatchesField : IStructuredSubfield
            {
                private readonly IField field;
                public readonly ISubfield RULES;
                public readonly ISubfield WEIGHT;
                public string FieldName => field.FieldName;
                public string FieldType => field.FieldType;
                public ObjectEncoding? ObjectEncoding => field.ObjectEncoding;
                public IField ParentField => field.ParentField;
                public bool IsMultivalue => field.IsMultivalue;
                public bool IsMandatory => field.IsMandatory;
                public bool IsCaseInsensitive => field.IsCaseInsensitive;
                public bool IsTokenizedPath => field.IsTokenizedPath;
                internal GrammarMatchesField()
                {
                    this.field = new FieldImpl("GRAMMAR_MATCHES", "grammar_matches", MicroFocus.FAS.AdapterSdkSchema.ObjectEncoding.Json, true, false, false, false);
                    this.RULES = new SubfieldImpl("RULES", "STRING", null, true, false, false, false, this);
                    this.WEIGHT = new SubfieldImpl("WEIGHT", "INTEGER", null, false, false, false, false, this);
                }
            }
        }

        public class MetadataFilesField : IStructuredField
        {
            private readonly IField field;
            public readonly ISubfield CONTENT;
            public readonly ISubfield EXTENSION;
            public string FieldName => field.FieldName;
            public string FieldType => field.FieldType;
            public ObjectEncoding? ObjectEncoding => field.ObjectEncoding;
            public IField ParentField => field.ParentField;
            public bool IsMultivalue => field.IsMultivalue;
            public bool IsMandatory => field.IsMandatory;
            public bool IsCaseInsensitive => field.IsCaseInsensitive;
            public bool IsTokenizedPath => field.IsTokenizedPath;
            internal MetadataFilesField()
            {
                this.field = new FieldImpl("METADATA_FILES", "metadata_files", MicroFocus.FAS.AdapterSdkSchema.ObjectEncoding.Flattened, true, false, false, false);
                this.CONTENT = new SubfieldImpl("CONTENT", "FULLTEXT", null, false, true, true, false, this);
                this.EXTENSION = new SubfieldImpl("EXTENSION", "STRING", null, false, true, true, false, this);
            }
        }

        public class OcrField : IStructuredField
        {
            private readonly IField field;
            public readonly ISubfield CONFIDENCE;
            public readonly ISubfield NAME;
            public readonly ISubfield TYPE;
            public readonly ISubfield VALUE;
            public string FieldName => field.FieldName;
            public string FieldType => field.FieldType;
            public ObjectEncoding? ObjectEncoding => field.ObjectEncoding;
            public IField ParentField => field.ParentField;
            public bool IsMultivalue => field.IsMultivalue;
            public bool IsMandatory => field.IsMandatory;
            public bool IsCaseInsensitive => field.IsCaseInsensitive;
            public bool IsTokenizedPath => field.IsTokenizedPath;
            internal OcrField()
            {
                this.field = new FieldImpl("OCR", "ocr[]", MicroFocus.FAS.AdapterSdkSchema.ObjectEncoding.Flattened, true, false, false, false);
                this.CONFIDENCE = new SubfieldImpl("CONFIDENCE", "INTEGER", null, false, true, false, false, this);
                this.NAME = new SubfieldImpl("NAME", "STRING", null, false, false, false, false, this);
                this.TYPE = new SubfieldImpl("TYPE", "STRING", null, false, false, false, false, this);
                this.VALUE = new SubfieldImpl("VALUE", "FULLTEXT", null, false, true, false, false, this);
            }
        }
    }
}