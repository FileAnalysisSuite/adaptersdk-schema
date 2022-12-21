/*
 * Copyright 2022 Micro Focus or one of its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.fileanalysissuite.adaptersdk.schema;

import io.github.fileanalysissuite.adaptersdk.schema.model.Field;
import io.github.fileanalysissuite.adaptersdk.schema.model.StructuredField;
import io.github.fileanalysissuite.adaptersdk.schema.model.StructuredSubfield;
import io.github.fileanalysissuite.adaptersdk.schema.model.Subfield;
import java.lang.String;
import javax.annotation.Nonnull;

public final class TestSchema {
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
  public static final Field DATE_PROCESSED = new FieldImpl("DATE_PROCESSED", "DATETIME", null, false, false, false, false);

  @Nonnull
  public static final Field DIRECTION = new FieldImpl("DIRECTION", "STRING", null, false, false, false, false);

  @Nonnull
  public static final EntitiesField ENTITIES = new EntitiesField();

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
  public static final OcrField OCR = new OcrField();

  @Nonnull
  public static final Field PARENT_REFERENCE = new FieldImpl("PARENT_REFERENCE", "STRING", null, false, false, false, false);

  @Nonnull
  public static final Field PRIORITY = new FieldImpl("PRIORITY", "LONG", null, false, false, false, false);

  @Nonnull
  public static final Field REPO_CLASSIFICATION = new FieldImpl("REPO_CLASSIFICATION", "STRING", null, true, false, false, false);

  @Nonnull
  public static final Field REPO_FOLDER = new FieldImpl("REPO_FOLDER", "STRING", null, false, false, true, false);

  @Nonnull
  public static final Field REPO_LABELS = new FieldImpl("REPO_LABELS", "STRING", null, true, false, true, false);

  @Nonnull
  public static final Field REPO_NOTES = new FieldImpl("REPO_NOTES", "STRING", null, false, false, true, false);

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
  public static final Field SCAN_REFERENCE = new FieldImpl("SCAN_REFERENCE", "STRING", null, false, false, false, false);

  @Nonnull
  public static final Field SOURCE_REFERENCE = new FieldImpl("SOURCE_REFERENCE", "STRING", null, false, false, false, false);

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
  public static final Field TYPE = new FieldImpl("TYPE", "STRING", null, false, true, false, false);

  private TestSchema() {
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
      case "DATE_PROCESSED":
        return DATE_PROCESSED;
      case "DIRECTION":
        return DIRECTION;
      case "ENTITIES":
        return ENTITIES;
      case "ENTITIES.ENTITY_CATEGORY_ID":
        return ENTITIES.ENTITY_CATEGORY_ID;
      case "ENTITIES.ENTITY_ID":
        return ENTITIES.ENTITY_ID;
      case "ENTITIES.GRAMMAR_ID":
        return ENTITIES.GRAMMAR_ID;
      case "ENTITIES.MATCHES":
        return ENTITIES.MATCHES;
      case "ENTITIES.MATCHES.CONTEXT":
        return ENTITIES.MATCHES.CONTEXT;
      case "ENTITIES.MATCHES.VALUE":
        return ENTITIES.MATCHES.VALUE;
      case "ENTITIES.MATCHES.SCORE":
        return ENTITIES.MATCHES.SCORE;
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
      case "REPO_FOLDER":
        return REPO_FOLDER;
      case "REPO_LABELS":
        return REPO_LABELS;
      case "REPO_NOTES":
        return REPO_NOTES;
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
      case "SCAN_REFERENCE":
        return SCAN_REFERENCE;
      case "SOURCE_REFERENCE":
        return SOURCE_REFERENCE;
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
      case "DATE_PROCESSED":
        return DATE_PROCESSED;
      case "DIRECTION":
        return DIRECTION;
      case "ENTITIES":
        return ENTITIES;
      case "ENTITIES.ENTITY_CATEGORY_ID":
        return ENTITIES.ENTITY_CATEGORY_ID;
      case "ENTITIES.ENTITY_ID":
        return ENTITIES.ENTITY_ID;
      case "ENTITIES.GRAMMAR_ID":
        return ENTITIES.GRAMMAR_ID;
      case "ENTITIES.MATCHES":
        return ENTITIES.MATCHES;
      case "ENTITIES.MATCHES.CONTEXT":
        return ENTITIES.MATCHES.CONTEXT;
      case "ENTITIES.MATCHES.VALUE":
        return ENTITIES.MATCHES.VALUE;
      case "ENTITIES.MATCHES.SCORE":
        return ENTITIES.MATCHES.SCORE;
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
      case "REPO_FOLDER":
        return REPO_FOLDER;
      case "REPO_LABELS":
        return REPO_LABELS;
      case "REPO_NOTES":
        return REPO_NOTES;
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
      case "SCAN_REFERENCE":
        return SCAN_REFERENCE;
      case "SOURCE_REFERENCE":
        return SOURCE_REFERENCE;
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

  public static final class EntitiesField extends FieldImpl implements StructuredField {
    @Nonnull
    public final Subfield ENTITY_CATEGORY_ID = new SubfieldImpl("ENTITY_CATEGORY_ID", "STRING", null, false, false, false, false, this);

    @Nonnull
    public final Subfield ENTITY_ID = new SubfieldImpl("ENTITY_ID", "STRING", null, true, false, false, false, this);

    @Nonnull
    public final Subfield GRAMMAR_ID = new SubfieldImpl("GRAMMAR_ID", "STRING", null, false, false, false, false, this);

    @Nonnull
    public final MatchesField MATCHES = new MatchesField();

    private EntitiesField() {
      super("ENTITIES", "entity_details", Field.ObjectEncoding.JSON, true, false, false, false);
    }

    public final class MatchesField extends SubfieldImpl implements StructuredSubfield {
      @Nonnull
      public final Subfield CONTEXT = new SubfieldImpl("CONTEXT", "STRING", null, true, false, false, false, this);

      @Nonnull
      public final Subfield VALUE = new SubfieldImpl("VALUE", "STRING", null, false, false, false, false, this);

      @Nonnull
      public final Subfield SCORE = new SubfieldImpl("SCORE", "DOUBLE", null, false, false, false, false, this);

      private MatchesField() {
        super("MATCHES", "entity_details_matches", Field.ObjectEncoding.JSON, true, false, false, false, EntitiesField.this);
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
}
