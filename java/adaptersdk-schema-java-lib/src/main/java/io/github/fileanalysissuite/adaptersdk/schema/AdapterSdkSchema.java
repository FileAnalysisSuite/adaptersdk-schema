//
// This file is auto-generated by SchemaGenerator
//
package io.github.fileanalysissuite.adaptersdk.schema;

import io.github.fileanalysissuite.adaptersdk.schema.model.Field;
import io.github.fileanalysissuite.adaptersdk.schema.model.StructuredField;
import io.github.fileanalysissuite.adaptersdk.schema.model.StructuredSubfield;
import io.github.fileanalysissuite.adaptersdk.schema.model.Subfield;
import java.lang.String;
import javax.annotation.Nonnull;

public final class AdapterSdkSchema {
  @Nonnull
  public static final AccountsField ACCOUNTS = new AccountsField();

  @Nonnull
  public static final Field ADDRESS_BCC = new FieldImpl("ADDRESS_BCC", "STRING", null, true, false, false, false);

  @Nonnull
  public static final Field ADDRESS_CC = new FieldImpl("ADDRESS_CC", "STRING", null, true, false, false, false);

  @Nonnull
  public static final Field ADDRESS_DISPLAY_BCC = new FieldImpl("ADDRESS_DISPLAY_BCC", "FULLTEXT", null, true, false, true, false);

  @Nonnull
  public static final Field ADDRESS_DISPLAY_CC = new FieldImpl("ADDRESS_DISPLAY_CC", "FULLTEXT", null, true, false, true, false);

  @Nonnull
  public static final Field ADDRESS_DISPLAY_FROM = new FieldImpl("ADDRESS_DISPLAY_FROM", "FULLTEXT", null, false, false, true, false);

  @Nonnull
  public static final Field ADDRESS_DISPLAY_TO = new FieldImpl("ADDRESS_DISPLAY_TO", "FULLTEXT", null, true, false, true, false);

  @Nonnull
  public static final Field ADDRESS_FROM = new FieldImpl("ADDRESS_FROM", "STRING", null, false, false, false, false);

  @Nonnull
  public static final Field ADDRESS_TO = new FieldImpl("ADDRESS_TO", "STRING", null, true, false, false, false);

  @Nonnull
  public static final Field CC = new FieldImpl("CC", "STRING", null, false, false, false, false);

  @Nonnull
  public static final ColumnsField COLUMNS = new ColumnsField();

  @Nonnull
  public static final Field COLUMN_COUNT = new FieldImpl("COLUMN_COUNT", "INTEGER", null, false, false, false, false);

  @Nonnull
  public static final Field CONTENT_PRIMARY = new FieldImpl("CONTENT_PRIMARY", "FULLTEXT", null, false, false, true, false);

  @Nonnull
  public static final Field DATE_ARCHIVED = new FieldImpl("DATE_ARCHIVED", "DATETIME", null, false, false, false, false);

  @Nonnull
  public static final Field DATE_CREATED = new FieldImpl("DATE_CREATED", "DATETIME", null, false, false, false, false);

  @Nonnull
  public static final Field DATE_MODIFIED = new FieldImpl("DATE_MODIFIED", "DATETIME", null, false, false, false, false);

  @Nonnull
  public static final Field DATE_POSTED = new FieldImpl("DATE_POSTED", "DATETIME", null, false, false, false, false);

  @Nonnull
  public static final Field DIRECTION = new FieldImpl("DIRECTION", "STRING", null, false, false, false, false);

  @Nonnull
  public static final Field EXTRACTION_INDEX = new FieldImpl("EXTRACTION_INDEX", "STRING", null, false, false, false, false);

  @Nonnull
  public static final Field EXTRACTION_TYPE = new FieldImpl("EXTRACTION_TYPE", "STRING", null, false, false, false, false);

  @Nonnull
  public static final Field FAMILY_ADDRESS_BCC = new FieldImpl("FAMILY_ADDRESS_BCC", "STRING", null, true, false, false, false);

  @Nonnull
  public static final Field FAMILY_ADDRESS_CC = new FieldImpl("FAMILY_ADDRESS_CC", "STRING", null, true, false, false, false);

  @Nonnull
  public static final Field FAMILY_ADDRESS_DISPLAY_BCC = new FieldImpl("FAMILY_ADDRESS_DISPLAY_BCC", "FULLTEXT", null, true, false, true, false);

  @Nonnull
  public static final Field FAMILY_ADDRESS_DISPLAY_CC = new FieldImpl("FAMILY_ADDRESS_DISPLAY_CC", "FULLTEXT", null, true, false, true, false);

  @Nonnull
  public static final Field FAMILY_ADDRESS_DISPLAY_FROM = new FieldImpl("FAMILY_ADDRESS_DISPLAY_FROM", "FULLTEXT", null, false, false, true, false);

  @Nonnull
  public static final Field FAMILY_ADDRESS_DISPLAY_TO = new FieldImpl("FAMILY_ADDRESS_DISPLAY_TO", "FULLTEXT", null, true, false, true, false);

  @Nonnull
  public static final Field FAMILY_ADDRESS_FROM = new FieldImpl("FAMILY_ADDRESS_FROM", "STRING", null, false, false, false, false);

  @Nonnull
  public static final Field FAMILY_ADDRESS_TO = new FieldImpl("FAMILY_ADDRESS_TO", "STRING", null, true, false, false, false);

  @Nonnull
  public static final Field FAMILY_DATE_POSTED = new FieldImpl("FAMILY_DATE_POSTED", "DATETIME", null, false, false, false, false);

  @Nonnull
  public static final Field FAMILY_THREAD_TOPIC = new FieldImpl("FAMILY_THREAD_TOPIC", "STRING", null, false, false, false, false);

  @Nonnull
  public static final Field FAMILY_TITLE = new FieldImpl("FAMILY_TITLE", "FULLTEXT", null, false, false, true, false);

  @Nonnull
  public static final Field FILE_EXT = new FieldImpl("FILE_EXT", "STRING", null, false, false, true, false);

  @Nonnull
  public static final Field FILE_NAME = new FieldImpl("FILE_NAME", "STRING", null, false, true, true, false);

  @Nonnull
  public static final Field FILE_SIZE = new FieldImpl("FILE_SIZE", "LONG", null, false, false, false, false);

  @Nonnull
  public static final Field FILEPATH = new FieldImpl("FILEPATH", "STRING", null, false, false, true, true);

  @Nonnull
  public static final Field FROM = new FieldImpl("FROM", "STRING", null, false, false, false, false);

  @Nonnull
  public static final Field HAS_ATTACHMENTS = new FieldImpl("HAS_ATTACHMENTS", "BOOLEAN", null, false, false, false, false);

  @Nonnull
  public static final Field HASH = new FieldImpl("HASH", "STRING", null, false, true, false, false);

  @Nonnull
  public static final Field IS_OLE = new FieldImpl("IS_OLE", "BOOLEAN", null, false, false, false, false);

  @Nonnull
  public static final Field MESSAGE_ID = new FieldImpl("MESSAGE_ID", "STRING", null, false, false, false, false);

  @Nonnull
  public static final MetadataFilesField METADATA_FILES = new MetadataFilesField();

  @Nonnull
  public static final Field MIMETYPE = new FieldImpl("MIMETYPE", "STRING", null, false, true, true, false);

  @Nonnull
  public static final MipLabelsField MIP_LABELS = new MipLabelsField();

  @Nonnull
  public static final OcrField OCR = new OcrField();

  @Nonnull
  public static final Field PARENT_REFERENCE = new FieldImpl("PARENT_REFERENCE", "STRING", null, false, false, false, false);

  @Nonnull
  public static final Field PRIORITY = new FieldImpl("PRIORITY", "LONG", null, false, false, false, false);

  @Nonnull
  public static final Field REPO_CLASSIFICATION = new FieldImpl("REPO_CLASSIFICATION", "STRING", null, true, false, false, false);

  @Nonnull
  public static final Field REPO_EXPANDEDNUMBER = new FieldImpl("REPO_EXPANDEDNUMBER", "STRING", null, false, false, false, false);

  @Nonnull
  public static final Field REPO_FOLDER = new FieldImpl("REPO_FOLDER", "STRING", null, false, false, true, false);

  @Nonnull
  public static final Field REPO_LABELS = new FieldImpl("REPO_LABELS", "STRING", null, true, false, true, false);

  @Nonnull
  public static final Field REPO_NOTES = new FieldImpl("REPO_NOTES", "STRING", null, false, false, true, false);

  @Nonnull
  public static final Field REPO_RECORDNUMBER = new FieldImpl("REPO_RECORDNUMBER", "STRING", null, false, false, false, false);

  @Nonnull
  public static final Field REPO_RECORDTYPE = new FieldImpl("REPO_RECORDTYPE", "STRING", null, false, false, false, false);

  @Nonnull
  public static final Field REPO_URI = new FieldImpl("REPO_URI", "LONG", null, false, false, false, false);

  @Nonnull
  public static final Field ROOT_DATE_MODIFIED = new FieldImpl("ROOT_DATE_MODIFIED", "DATETIME", null, false, false, false, false);

  @Nonnull
  public static final Field ROOT_FILE_EXT = new FieldImpl("ROOT_FILE_EXT", "STRING", null, false, false, true, false);

  @Nonnull
  public static final Field ROOT_FILEPATH = new FieldImpl("ROOT_FILEPATH", "FULLTEXT", null, false, false, false, false);

  @Nonnull
  public static final Field ROOT_FILE_SIZE = new FieldImpl("ROOT_FILE_SIZE", "LONG", null, false, false, false, false);

  @Nonnull
  public static final Field ROOT_REPO_CLASSIFICATION = new FieldImpl("ROOT_REPO_CLASSIFICATION", "STRING", null, true, false, true, false);

  @Nonnull
  public static final Field ROOT_REPO_RECORDTYPE = new FieldImpl("ROOT_REPO_RECORDTYPE", "STRING", null, false, false, true, false);

  @Nonnull
  public static final Field ROW_COUNT = new FieldImpl("ROW_COUNT", "LONG", null, false, false, false, false);

  @Nonnull
  public static final Field SCAN_REFERENCE = new FieldImpl("SCAN_REFERENCE", "STRING", null, false, false, false, false);

  @Nonnull
  public static final Field SOURCE_REFERENCE = new FieldImpl("SOURCE_REFERENCE", "STRING", null, false, false, false, false);

  @Nonnull
  public static final TableMetadataField TABLE_METADATA = new TableMetadataField();

  @Nonnull
  public static final Field TABLE_TYPE = new FieldImpl("TABLE_TYPE", "STRING", null, false, false, false, false);

  @Nonnull
  public static final Field THREAD_INDEX = new FieldImpl("THREAD_INDEX", "STRING", null, false, false, false, false);

  @Nonnull
  public static final Field THREAD_REPLY_TO = new FieldImpl("THREAD_REPLY_TO", "STRING", null, false, false, false, false);

  @Nonnull
  public static final Field THREAD_TOPIC = new FieldImpl("THREAD_TOPIC", "STRING", null, false, false, false, false);

  @Nonnull
  public static final Field TITLE = new FieldImpl("TITLE", "FULLTEXT", null, false, true, true, false);

  @Nonnull
  public static final Field TO = new FieldImpl("TO", "STRING", null, false, false, false, false);

  @Nonnull
  public static final Field UNIQUE_ID = new FieldImpl("UNIQUE_ID", "STRING", null, false, false, false, false);

  private AdapterSdkSchema() {
  }

  public static Field getField(final String fieldName) {
    switch (fieldName) {
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
      case "MIP_LABELS":
        return MIP_LABELS;
      case "MIP_LABELS.SITE_ID":
        return MIP_LABELS.SITE_ID;
      case "MIP_LABELS.ID":
        return MIP_LABELS.ID;
      case "MIP_LABELS.SETDATE":
        return MIP_LABELS.SETDATE;
      case "MIP_LABELS.NAME":
        return MIP_LABELS.NAME;
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
      case "TABLE_METADATA":
        return TABLE_METADATA;
      case "TABLE_METADATA.IS_SHUFFLED":
        return TABLE_METADATA.IS_SHUFFLED;
      case "TABLE_METADATA.SAMPLE_ROW_COUNT":
        return TABLE_METADATA.SAMPLE_ROW_COUNT;
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
      case "UNIQUE_ID":
        return UNIQUE_ID;
      default:
        throw new FieldNotFoundException(fieldName);
    }
  }

  public static Field getField(final String fieldName, final boolean ignoreCase) {
    if (!ignoreCase) {
      return getField(fieldName);
    }
    switch (fieldName.toUpperCase(java.util.Locale.ENGLISH)) {
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
      case "MIP_LABELS":
        return MIP_LABELS;
      case "MIP_LABELS.SITE_ID":
        return MIP_LABELS.SITE_ID;
      case "MIP_LABELS.ID":
        return MIP_LABELS.ID;
      case "MIP_LABELS.SETDATE":
        return MIP_LABELS.SETDATE;
      case "MIP_LABELS.NAME":
        return MIP_LABELS.NAME;
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
      case "TABLE_METADATA":
        return TABLE_METADATA;
      case "TABLE_METADATA.IS_SHUFFLED":
        return TABLE_METADATA.IS_SHUFFLED;
      case "TABLE_METADATA.SAMPLE_ROW_COUNT":
        return TABLE_METADATA.SAMPLE_ROW_COUNT;
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
      case "UNIQUE_ID":
        return UNIQUE_ID;
      default:
        throw new FieldNotFoundException(fieldName);
    }
  }

  public static final class AccountsField extends FieldImpl implements StructuredField {
    @Nonnull
    public final Subfield DISPLAY_NAME = new SubfieldImpl("DISPLAY_NAME", "FULLTEXT", null, false, false, true, false, this);

    @Nonnull
    public final Subfield HANDLES = new SubfieldImpl("HANDLES", "FULLTEXT", null, true, false, true, false, this);

    @Nonnull
    public final Subfield IDENTIFIER = new SubfieldImpl("IDENTIFIER", "FULLTEXT", null, false, false, true, false, this);

    @Nonnull
    public final Subfield IDENTIFIER_TYPE = new SubfieldImpl("IDENTIFIER_TYPE", "FULLTEXT", null, false, false, true, false, this);

    @Nonnull
    public final Subfield SENDER = new SubfieldImpl("SENDER", "BOOLEAN", null, false, false, false, false, this);

    private AccountsField() {
      super("ACCOUNTS", "person", Field.ObjectEncoding.JSON, true, false, false, false);
    }
  }

  public static final class ColumnsField extends FieldImpl implements StructuredField {
    @Nonnull
    public final GrammarMatchesField GRAMMAR_MATCHES = new GrammarMatchesField();

    @Nonnull
    public final Subfield NAME = new SubfieldImpl("NAME", "STRING", null, false, false, false, false, this);

    @Nonnull
    public final Subfield REVIEWED_BY = new SubfieldImpl("REVIEWED_BY", "FULLTEXT", null, false, false, true, false, this);

    @Nonnull
    public final Subfield REVIEWER_COMMENTS = new SubfieldImpl("REVIEWER_COMMENTS", "FULLTEXT", null, false, false, true, false, this);

    @Nonnull
    public final Subfield SELECTED_GRAMMAR_RULE = new SubfieldImpl("SELECTED_GRAMMAR_RULE", "STRING", null, false, false, false, false, this);

    @Nonnull
    public final Subfield STATUS = new SubfieldImpl("STATUS", "STRING", null, false, false, false, false, this);

    @Nonnull
    public final Subfield TYPE = new SubfieldImpl("TYPE", "STRING", null, false, false, false, false, this);

    private ColumnsField() {
      super("COLUMNS", "columns", Field.ObjectEncoding.JSON, true, false, false, false);
    }

    public final class GrammarMatchesField extends SubfieldImpl implements StructuredSubfield {
      @Nonnull
      public final Subfield RULES = new SubfieldImpl("RULES", "STRING", null, true, false, false, false, this);

      @Nonnull
      public final Subfield WEIGHT = new SubfieldImpl("WEIGHT", "INTEGER", null, false, false, false, false, this);

      private GrammarMatchesField() {
        super("GRAMMAR_MATCHES", "grammar_matches", Field.ObjectEncoding.JSON, true, false, false, false, ColumnsField.this);
      }
    }
  }

  public static final class MetadataFilesField extends FieldImpl implements StructuredField {
    @Nonnull
    public final Subfield CONTENT = new SubfieldImpl("CONTENT", "FULLTEXT", null, false, true, true, false, this);

    @Nonnull
    public final Subfield EXTENSION = new SubfieldImpl("EXTENSION", "STRING", null, false, true, true, false, this);

    private MetadataFilesField() {
      super("METADATA_FILES", "metadata_files", Field.ObjectEncoding.FLATTENED, true, false, false, false);
    }
  }

  public static final class MipLabelsField extends FieldImpl implements StructuredField {
    @Nonnull
    public final Subfield SITE_ID = new SubfieldImpl("SITE_ID", "STRING", null, false, false, false, false, this);

    @Nonnull
    public final Subfield ID = new SubfieldImpl("ID", "STRING", null, false, false, false, false, this);

    @Nonnull
    public final Subfield SETDATE = new SubfieldImpl("SETDATE", "DATETIME", null, false, false, false, false, this);

    @Nonnull
    public final Subfield NAME = new SubfieldImpl("NAME", "STRING", null, false, false, false, false, this);

    private MipLabelsField() {
      super("MIP_LABELS", "mip_labels", Field.ObjectEncoding.FLATTENED, true, false, false, false);
    }
  }

  public static final class OcrField extends FieldImpl implements StructuredField {
    @Nonnull
    public final Subfield CONFIDENCE = new SubfieldImpl("CONFIDENCE", "INTEGER", null, false, true, false, false, this);

    @Nonnull
    public final Subfield NAME = new SubfieldImpl("NAME", "STRING", null, false, false, false, false, this);

    @Nonnull
    public final Subfield TYPE = new SubfieldImpl("TYPE", "STRING", null, false, false, false, false, this);

    @Nonnull
    public final Subfield VALUE = new SubfieldImpl("VALUE", "FULLTEXT", null, false, true, false, false, this);

    private OcrField() {
      super("OCR", "ocr[]", Field.ObjectEncoding.FLATTENED, true, false, false, false);
    }
  }

  public static final class TableMetadataField extends FieldImpl implements StructuredField {
    @Nonnull
    public final Subfield IS_SHUFFLED = new SubfieldImpl("IS_SHUFFLED", "BOOLEAN", null, false, true, false, false, this);

    @Nonnull
    public final Subfield SAMPLE_ROW_COUNT = new SubfieldImpl("SAMPLE_ROW_COUNT", "INTEGER", null, false, true, false, false, this);

    private TableMetadataField() {
      super("TABLE_METADATA", "table_metadata", Field.ObjectEncoding.JSON, false, false, false, false);
    }
  }
}
