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

import io.github.fileanalysissuite.adaptersdk.schema.builders.JsonBuilder;
import io.github.fileanalysissuite.adaptersdk.schema.builders.SchemaObjectBuilder;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class TestSchemaObjectBuilder {
  private final SchemaObjectBuilder schemaObjectBuilder;

  public TestSchemaObjectBuilder(final SchemaObjectBuilder schemaObjectBuilder) {
    this.schemaObjectBuilder = schemaObjectBuilder;
  }

  public void setAccounts(final Consumer<AccountsObjectBuilder> builder) {
    final AccountsObjectBuilder accountsBuilder = new AccountsObjectBuilder();
    builder.accept(accountsBuilder);
    schemaObjectBuilder.setJsonFieldValue(
      TestSchema.ACCOUNTS,
      jsonBuilder ->  {
        accountsBuilder.build(jsonBuilder);
    }
    );
  }

  public void setAccounts(final Stream<Consumer<AccountsObjectBuilder>> builders) {
    schemaObjectBuilder.setJsonFieldValue(
      TestSchema.ACCOUNTS,
      builders.<Consumer<JsonBuilder>>map(builder -> {
        final AccountsObjectBuilder accountsBuilder = new AccountsObjectBuilder();
        builder.accept(accountsBuilder);
        return jsonBuilder -> {
          accountsBuilder.build(jsonBuilder);
        };
    }));
  }

  public void setAccounts(final List<Consumer<AccountsObjectBuilder>> builders) {
    setAccounts(builders.stream());
  }

  public void clearAccounts() {
    schemaObjectBuilder.clearField(TestSchema.ACCOUNTS);
  }

  public void setAddressBcc(final String... values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.ADDRESS_BCC, values);
  }

  public void setAddressBcc(final List<String> values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.ADDRESS_BCC, values);
  }

  public void addAddressBcc(final String value) {
    schemaObjectBuilder.addStringFieldValue(TestSchema.ADDRESS_BCC, value);
  }

  public void setAddressBcc(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.ADDRESS_BCC, value);
  }

  public void clearAddressBcc() {
    schemaObjectBuilder.clearField(TestSchema.ADDRESS_BCC);
  }

  public void setAddressCc(final String... values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.ADDRESS_CC, values);
  }

  public void setAddressCc(final List<String> values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.ADDRESS_CC, values);
  }

  public void addAddressCc(final String value) {
    schemaObjectBuilder.addStringFieldValue(TestSchema.ADDRESS_CC, value);
  }

  public void setAddressCc(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.ADDRESS_CC, value);
  }

  public void clearAddressCc() {
    schemaObjectBuilder.clearField(TestSchema.ADDRESS_CC);
  }

  public void setAddressDisplayBcc(final String... values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.ADDRESS_DISPLAY_BCC, values);
  }

  public void setAddressDisplayBcc(final List<String> values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.ADDRESS_DISPLAY_BCC, values);
  }

  public void addAddressDisplayBcc(final String value) {
    schemaObjectBuilder.addStringFieldValue(TestSchema.ADDRESS_DISPLAY_BCC, value);
  }

  public void setAddressDisplayBcc(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.ADDRESS_DISPLAY_BCC, value);
  }

  public void clearAddressDisplayBcc() {
    schemaObjectBuilder.clearField(TestSchema.ADDRESS_DISPLAY_BCC);
  }

  public void setAddressDisplayCc(final String... values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.ADDRESS_DISPLAY_CC, values);
  }

  public void setAddressDisplayCc(final List<String> values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.ADDRESS_DISPLAY_CC, values);
  }

  public void addAddressDisplayCc(final String value) {
    schemaObjectBuilder.addStringFieldValue(TestSchema.ADDRESS_DISPLAY_CC, value);
  }

  public void setAddressDisplayCc(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.ADDRESS_DISPLAY_CC, value);
  }

  public void clearAddressDisplayCc() {
    schemaObjectBuilder.clearField(TestSchema.ADDRESS_DISPLAY_CC);
  }

  public void setAddressDisplayFrom(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.ADDRESS_DISPLAY_FROM, value);
  }

  public void clearAddressDisplayFrom() {
    schemaObjectBuilder.clearField(TestSchema.ADDRESS_DISPLAY_FROM);
  }

  public void setAddressDisplayTo(final String... values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.ADDRESS_DISPLAY_TO, values);
  }

  public void setAddressDisplayTo(final List<String> values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.ADDRESS_DISPLAY_TO, values);
  }

  public void addAddressDisplayTo(final String value) {
    schemaObjectBuilder.addStringFieldValue(TestSchema.ADDRESS_DISPLAY_TO, value);
  }

  public void setAddressDisplayTo(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.ADDRESS_DISPLAY_TO, value);
  }

  public void clearAddressDisplayTo() {
    schemaObjectBuilder.clearField(TestSchema.ADDRESS_DISPLAY_TO);
  }

  public void setAddressFrom(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.ADDRESS_FROM, value);
  }

  public void clearAddressFrom() {
    schemaObjectBuilder.clearField(TestSchema.ADDRESS_FROM);
  }

  public void setAddressTo(final String... values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.ADDRESS_TO, values);
  }

  public void setAddressTo(final List<String> values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.ADDRESS_TO, values);
  }

  public void addAddressTo(final String value) {
    schemaObjectBuilder.addStringFieldValue(TestSchema.ADDRESS_TO, value);
  }

  public void setAddressTo(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.ADDRESS_TO, value);
  }

  public void clearAddressTo() {
    schemaObjectBuilder.clearField(TestSchema.ADDRESS_TO);
  }

  public void setCc(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.CC, value);
  }

  public void clearCc() {
    schemaObjectBuilder.clearField(TestSchema.CC);
  }

  public void setContentPrimary(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.CONTENT_PRIMARY, value);
  }

  public void clearContentPrimary() {
    schemaObjectBuilder.clearField(TestSchema.CONTENT_PRIMARY);
  }

  public void setDateArchived(final Instant value) {
    schemaObjectBuilder.setInstantFieldValue(TestSchema.DATE_ARCHIVED, value);
  }

  public void clearDateArchived() {
    schemaObjectBuilder.clearField(TestSchema.DATE_ARCHIVED);
  }

  public void setDateCreated(final Instant value) {
    schemaObjectBuilder.setInstantFieldValue(TestSchema.DATE_CREATED, value);
  }

  public void clearDateCreated() {
    schemaObjectBuilder.clearField(TestSchema.DATE_CREATED);
  }

  public void setDateModified(final Instant value) {
    schemaObjectBuilder.setInstantFieldValue(TestSchema.DATE_MODIFIED, value);
  }

  public void clearDateModified() {
    schemaObjectBuilder.clearField(TestSchema.DATE_MODIFIED);
  }

  public void setDatePosted(final Instant value) {
    schemaObjectBuilder.setInstantFieldValue(TestSchema.DATE_POSTED, value);
  }

  public void clearDatePosted() {
    schemaObjectBuilder.clearField(TestSchema.DATE_POSTED);
  }

  public void setDateProcessed(final Instant value) {
    schemaObjectBuilder.setInstantFieldValue(TestSchema.DATE_PROCESSED, value);
  }

  public void clearDateProcessed() {
    schemaObjectBuilder.clearField(TestSchema.DATE_PROCESSED);
  }

  public void setDirection(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.DIRECTION, value);
  }

  public void clearDirection() {
    schemaObjectBuilder.clearField(TestSchema.DIRECTION);
  }

  public void setEntities(final Consumer<EntitiesObjectBuilder> builder) {
    final EntitiesObjectBuilder entitiesBuilder = new EntitiesObjectBuilder();
    builder.accept(entitiesBuilder);
    schemaObjectBuilder.setJsonFieldValue(
      TestSchema.ENTITIES,
      jsonBuilder ->  {
        entitiesBuilder.build(jsonBuilder);
    }
    );
  }

  public void setEntities(final Stream<Consumer<EntitiesObjectBuilder>> builders) {
    schemaObjectBuilder.setJsonFieldValue(
      TestSchema.ENTITIES,
      builders.<Consumer<JsonBuilder>>map(builder -> {
        final EntitiesObjectBuilder entitiesBuilder = new EntitiesObjectBuilder();
        builder.accept(entitiesBuilder);
        return jsonBuilder -> {
          entitiesBuilder.build(jsonBuilder);
        };
    }));
  }

  public void setEntities(final List<Consumer<EntitiesObjectBuilder>> builders) {
    setEntities(builders.stream());
  }

  public void clearEntities() {
    schemaObjectBuilder.clearField(TestSchema.ENTITIES);
  }

  public void setExtractionIndex(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.EXTRACTION_INDEX, value);
  }

  public void clearExtractionIndex() {
    schemaObjectBuilder.clearField(TestSchema.EXTRACTION_INDEX);
  }

  public void setExtractionType(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.EXTRACTION_TYPE, value);
  }

  public void clearExtractionType() {
    schemaObjectBuilder.clearField(TestSchema.EXTRACTION_TYPE);
  }

  public void setFamilyAddressBcc(final String... values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.FAMILY_ADDRESS_BCC, values);
  }

  public void setFamilyAddressBcc(final List<String> values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.FAMILY_ADDRESS_BCC, values);
  }

  public void addFamilyAddressBcc(final String value) {
    schemaObjectBuilder.addStringFieldValue(TestSchema.FAMILY_ADDRESS_BCC, value);
  }

  public void setFamilyAddressBcc(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.FAMILY_ADDRESS_BCC, value);
  }

  public void clearFamilyAddressBcc() {
    schemaObjectBuilder.clearField(TestSchema.FAMILY_ADDRESS_BCC);
  }

  public void setFamilyAddressCc(final String... values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.FAMILY_ADDRESS_CC, values);
  }

  public void setFamilyAddressCc(final List<String> values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.FAMILY_ADDRESS_CC, values);
  }

  public void addFamilyAddressCc(final String value) {
    schemaObjectBuilder.addStringFieldValue(TestSchema.FAMILY_ADDRESS_CC, value);
  }

  public void setFamilyAddressCc(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.FAMILY_ADDRESS_CC, value);
  }

  public void clearFamilyAddressCc() {
    schemaObjectBuilder.clearField(TestSchema.FAMILY_ADDRESS_CC);
  }

  public void setFamilyAddressDisplayBcc(final String... values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.FAMILY_ADDRESS_DISPLAY_BCC, values);
  }

  public void setFamilyAddressDisplayBcc(final List<String> values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.FAMILY_ADDRESS_DISPLAY_BCC, values);
  }

  public void addFamilyAddressDisplayBcc(final String value) {
    schemaObjectBuilder.addStringFieldValue(TestSchema.FAMILY_ADDRESS_DISPLAY_BCC, value);
  }

  public void setFamilyAddressDisplayBcc(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.FAMILY_ADDRESS_DISPLAY_BCC, value);
  }

  public void clearFamilyAddressDisplayBcc() {
    schemaObjectBuilder.clearField(TestSchema.FAMILY_ADDRESS_DISPLAY_BCC);
  }

  public void setFamilyAddressDisplayCc(final String... values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.FAMILY_ADDRESS_DISPLAY_CC, values);
  }

  public void setFamilyAddressDisplayCc(final List<String> values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.FAMILY_ADDRESS_DISPLAY_CC, values);
  }

  public void addFamilyAddressDisplayCc(final String value) {
    schemaObjectBuilder.addStringFieldValue(TestSchema.FAMILY_ADDRESS_DISPLAY_CC, value);
  }

  public void setFamilyAddressDisplayCc(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.FAMILY_ADDRESS_DISPLAY_CC, value);
  }

  public void clearFamilyAddressDisplayCc() {
    schemaObjectBuilder.clearField(TestSchema.FAMILY_ADDRESS_DISPLAY_CC);
  }

  public void setFamilyAddressDisplayFrom(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.FAMILY_ADDRESS_DISPLAY_FROM, value);
  }

  public void clearFamilyAddressDisplayFrom() {
    schemaObjectBuilder.clearField(TestSchema.FAMILY_ADDRESS_DISPLAY_FROM);
  }

  public void setFamilyAddressDisplayTo(final String... values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.FAMILY_ADDRESS_DISPLAY_TO, values);
  }

  public void setFamilyAddressDisplayTo(final List<String> values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.FAMILY_ADDRESS_DISPLAY_TO, values);
  }

  public void addFamilyAddressDisplayTo(final String value) {
    schemaObjectBuilder.addStringFieldValue(TestSchema.FAMILY_ADDRESS_DISPLAY_TO, value);
  }

  public void setFamilyAddressDisplayTo(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.FAMILY_ADDRESS_DISPLAY_TO, value);
  }

  public void clearFamilyAddressDisplayTo() {
    schemaObjectBuilder.clearField(TestSchema.FAMILY_ADDRESS_DISPLAY_TO);
  }

  public void setFamilyAddressFrom(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.FAMILY_ADDRESS_FROM, value);
  }

  public void clearFamilyAddressFrom() {
    schemaObjectBuilder.clearField(TestSchema.FAMILY_ADDRESS_FROM);
  }

  public void setFamilyAddressTo(final String... values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.FAMILY_ADDRESS_TO, values);
  }

  public void setFamilyAddressTo(final List<String> values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.FAMILY_ADDRESS_TO, values);
  }

  public void addFamilyAddressTo(final String value) {
    schemaObjectBuilder.addStringFieldValue(TestSchema.FAMILY_ADDRESS_TO, value);
  }

  public void setFamilyAddressTo(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.FAMILY_ADDRESS_TO, value);
  }

  public void clearFamilyAddressTo() {
    schemaObjectBuilder.clearField(TestSchema.FAMILY_ADDRESS_TO);
  }

  public void setFamilyDatePosted(final Instant value) {
    schemaObjectBuilder.setInstantFieldValue(TestSchema.FAMILY_DATE_POSTED, value);
  }

  public void clearFamilyDatePosted() {
    schemaObjectBuilder.clearField(TestSchema.FAMILY_DATE_POSTED);
  }

  public void setFamilyThreadTopic(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.FAMILY_THREAD_TOPIC, value);
  }

  public void clearFamilyThreadTopic() {
    schemaObjectBuilder.clearField(TestSchema.FAMILY_THREAD_TOPIC);
  }

  public void setFamilyTitle(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.FAMILY_TITLE, value);
  }

  public void clearFamilyTitle() {
    schemaObjectBuilder.clearField(TestSchema.FAMILY_TITLE);
  }

  public void setFileExt(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.FILE_EXT, value);
  }

  public void clearFileExt() {
    schemaObjectBuilder.clearField(TestSchema.FILE_EXT);
  }

  public void setFileName(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.FILE_NAME, value);
  }

  public void clearFileName() {
    schemaObjectBuilder.clearField(TestSchema.FILE_NAME);
  }

  public void setFileSize(final Long value) {
    schemaObjectBuilder.setLongFieldValue(TestSchema.FILE_SIZE, value);
  }

  public void clearFileSize() {
    schemaObjectBuilder.clearField(TestSchema.FILE_SIZE);
  }

  public void setFilepath(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.FILEPATH, value);
  }

  public void clearFilepath() {
    schemaObjectBuilder.clearField(TestSchema.FILEPATH);
  }

  public void setFrom(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.FROM, value);
  }

  public void clearFrom() {
    schemaObjectBuilder.clearField(TestSchema.FROM);
  }

  public void setHasAttachments(final Boolean value) {
    schemaObjectBuilder.setBooleanFieldValue(TestSchema.HAS_ATTACHMENTS, value);
  }

  public void clearHasAttachments() {
    schemaObjectBuilder.clearField(TestSchema.HAS_ATTACHMENTS);
  }

  public void setHash(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.HASH, value);
  }

  public void clearHash() {
    schemaObjectBuilder.clearField(TestSchema.HASH);
  }

  public void setIsOle(final Boolean value) {
    schemaObjectBuilder.setBooleanFieldValue(TestSchema.IS_OLE, value);
  }

  public void clearIsOle() {
    schemaObjectBuilder.clearField(TestSchema.IS_OLE);
  }

  public void setMessageId(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.MESSAGE_ID, value);
  }

  public void clearMessageId() {
    schemaObjectBuilder.clearField(TestSchema.MESSAGE_ID);
  }

  public void setMetadataFiles(final Consumer<MetadataFilesObjectBuilder> builder) {
      //TODO: flattened
      schemaObjectBuilder.setFlattenedFieldValue(
        TestSchema.METADATA_FILES,
        nextLevelBuilder ->  {
            final MetadataFilesObjectBuilder metadataFilesBuilder = new MetadataFilesObjectBuilder(nextLevelBuilder);
            builder.accept(metadataFilesBuilder); //'builder' is the function to set cont and ext
        }
      );
  }

  public void setMetadataFiles(final Stream<Consumer<MetadataFilesObjectBuilder>> builders)
  {
    //TODO: flattened
      schemaObjectBuilder.setFlattenedFieldValue(
          TestSchema.METADATA_FILES,
          builders.map(builder -> (nextLevelBuilder -> {
              final MetadataFilesObjectBuilder metadataFilesBuilder = new MetadataFilesObjectBuilder(nextLevelBuilder);
              builder.accept(metadataFilesBuilder);
          })));
  }

  public void setMetadataFiles(final List<Consumer<MetadataFilesObjectBuilder>> builders) {
    setMetadataFiles(builders.stream());
  }

  public void clearMetadataFiles() {
    schemaObjectBuilder.clearField(TestSchema.METADATA_FILES);
  }

  public void setMimetype(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.MIMETYPE, value);
  }

  public void clearMimetype() {
    schemaObjectBuilder.clearField(TestSchema.MIMETYPE);
  }

  public void setOcr(final Consumer<OcrListObjectBuilder> builder) {
    //TODO: flattened multi-dimension
    final OcrListObjectBuilder ocrBuilder = new OcrListObjectBuilder();
    builder.accept(ocrBuilder);
    schemaObjectBuilder.setJsonFieldValue(
      TestSchema.OCR,
      jsonBuilder ->  {
        ocrBuilder.build(jsonBuilder);
    }
    );
  }

  public void setOcr(final Stream<Consumer<OcrListObjectBuilder>> builders) {
    //TODO: flattened multi-dimension
    schemaObjectBuilder.setJsonFieldValue(
      TestSchema.OCR,
      builders.<Consumer<JsonBuilder>>map(builder -> {
        final OcrListObjectBuilder ocrBuilder = new OcrListObjectBuilder();
        builder.accept(ocrBuilder);
        return jsonBuilder -> {
          ocrBuilder.build(jsonBuilder);
        };
    }));
  }

  public void setOcr(final List<Consumer<OcrListObjectBuilder>> builders) {
    setOcr(builders.stream());
  }

  public void clearOcr() {
    schemaObjectBuilder.clearField(TestSchema.OCR);
  }

  public void setParentReference(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.PARENT_REFERENCE, value);
  }

  public void clearParentReference() {
    schemaObjectBuilder.clearField(TestSchema.PARENT_REFERENCE);
  }

  public void setPriority(final Long value) {
    schemaObjectBuilder.setLongFieldValue(TestSchema.PRIORITY, value);
  }

  public void clearPriority() {
    schemaObjectBuilder.clearField(TestSchema.PRIORITY);
  }

  public void setRepoClassification(final String... values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.REPO_CLASSIFICATION, values);
  }

  public void setRepoClassification(final List<String> values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.REPO_CLASSIFICATION, values);
  }

  public void addRepoClassification(final String value) {
    schemaObjectBuilder.addStringFieldValue(TestSchema.REPO_CLASSIFICATION, value);
  }

  public void setRepoClassification(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.REPO_CLASSIFICATION, value);
  }

  public void clearRepoClassification() {
    schemaObjectBuilder.clearField(TestSchema.REPO_CLASSIFICATION);
  }

  public void setRepoFolder(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.REPO_FOLDER, value);
  }

  public void clearRepoFolder() {
    schemaObjectBuilder.clearField(TestSchema.REPO_FOLDER);
  }

  public void setRepoLabels(final String... values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.REPO_LABELS, values);
  }

  public void setRepoLabels(final List<String> values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.REPO_LABELS, values);
  }

  public void addRepoLabels(final String value) {
    schemaObjectBuilder.addStringFieldValue(TestSchema.REPO_LABELS, value);
  }

  public void setRepoLabels(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.REPO_LABELS, value);
  }

  public void clearRepoLabels() {
    schemaObjectBuilder.clearField(TestSchema.REPO_LABELS);
  }

  public void setRepoNotes(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.REPO_NOTES, value);
  }

  public void clearRepoNotes() {
    schemaObjectBuilder.clearField(TestSchema.REPO_NOTES);
  }

  public void setRepoRecordtype(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.REPO_RECORDTYPE, value);
  }

  public void clearRepoRecordtype() {
    schemaObjectBuilder.clearField(TestSchema.REPO_RECORDTYPE);
  }

  public void setRepoUri(final Long value) {
    schemaObjectBuilder.setLongFieldValue(TestSchema.REPO_URI, value);
  }

  public void clearRepoUri() {
    schemaObjectBuilder.clearField(TestSchema.REPO_URI);
  }

  public void setRootDateModified(final Instant value) {
    schemaObjectBuilder.setInstantFieldValue(TestSchema.ROOT_DATE_MODIFIED, value);
  }

  public void clearRootDateModified() {
    schemaObjectBuilder.clearField(TestSchema.ROOT_DATE_MODIFIED);
  }

  public void setRootFileExt(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.ROOT_FILE_EXT, value);
  }

  public void clearRootFileExt() {
    schemaObjectBuilder.clearField(TestSchema.ROOT_FILE_EXT);
  }

  public void setRootFilepath(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.ROOT_FILEPATH, value);
  }

  public void clearRootFilepath() {
    schemaObjectBuilder.clearField(TestSchema.ROOT_FILEPATH);
  }

  public void setRootFileSize(final Long value) {
    schemaObjectBuilder.setLongFieldValue(TestSchema.ROOT_FILE_SIZE, value);
  }

  public void clearRootFileSize() {
    schemaObjectBuilder.clearField(TestSchema.ROOT_FILE_SIZE);
  }

  public void setRootRepoClassification(final String... values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.ROOT_REPO_CLASSIFICATION, values);
  }

  public void setRootRepoClassification(final List<String> values) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.ROOT_REPO_CLASSIFICATION, values);
  }

  public void addRootRepoClassification(final String value) {
    schemaObjectBuilder.addStringFieldValue(TestSchema.ROOT_REPO_CLASSIFICATION, value);
  }

  public void setRootRepoClassification(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.ROOT_REPO_CLASSIFICATION, value);
  }

  public void clearRootRepoClassification() {
    schemaObjectBuilder.clearField(TestSchema.ROOT_REPO_CLASSIFICATION);
  }

  public void setRootRepoRecordtype(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.ROOT_REPO_RECORDTYPE, value);
  }

  public void clearRootRepoRecordtype() {
    schemaObjectBuilder.clearField(TestSchema.ROOT_REPO_RECORDTYPE);
  }

  public void setScanReference(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.SCAN_REFERENCE, value);
  }

  public void clearScanReference() {
    schemaObjectBuilder.clearField(TestSchema.SCAN_REFERENCE);
  }

  public void setSourceReference(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.SOURCE_REFERENCE, value);
  }

  public void clearSourceReference() {
    schemaObjectBuilder.clearField(TestSchema.SOURCE_REFERENCE);
  }

  public void setThreadIndex(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.THREAD_INDEX, value);
  }

  public void clearThreadIndex() {
    schemaObjectBuilder.clearField(TestSchema.THREAD_INDEX);
  }

  public void setThreadReplyTo(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.THREAD_REPLY_TO, value);
  }

  public void clearThreadReplyTo() {
    schemaObjectBuilder.clearField(TestSchema.THREAD_REPLY_TO);
  }

  public void setThreadTopic(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.THREAD_TOPIC, value);
  }

  public void clearThreadTopic() {
    schemaObjectBuilder.clearField(TestSchema.THREAD_TOPIC);
  }

  public void setTitle(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.TITLE, value);
  }

  public void clearTitle() {
    schemaObjectBuilder.clearField(TestSchema.TITLE);
  }

  public void setTo(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.TO, value);
  }

  public void clearTo() {
    schemaObjectBuilder.clearField(TestSchema.TO);
  }

  public void setType(final String value) {
    schemaObjectBuilder.setStringFieldValue(TestSchema.TYPE, value);
  }

  public void clearType() {
    schemaObjectBuilder.clearField(TestSchema.TYPE);
  }

  public static final class AccountsObjectBuilder {
    private String displayName;

    private List<String> handles;

    private String identifier;

    private String identifierType;

    private Boolean sender;

    private AccountsObjectBuilder() {
    }

    public void setDisplayName(final String value) {
      this.displayName = value;
    }

    public void clearDisplayName() {
      displayName = null;
    }

    public void setHandles(final String... values) {
      this.handles = Arrays.asList(values);
    }

    public void setHandles(final List<String> values) {
      this.handles = values;
    }

    public void addHandles(final String value) {
      if (handles == null) {
        this.handles = new ArrayList<String>();
      }
      this.handles.add(value);
    }

    public void setHandles(final String value) {
      if (handles == null) {
        this.handles = new ArrayList<String>();
      }
      this.handles.add(value);
    }

    public void clearHandles() {
      handles = null;
    }

    public void setIdentifier(final String value) {
      this.identifier = value;
    }

    public void clearIdentifier() {
      identifier = null;
    }

    public void setIdentifierType(final String value) {
      this.identifierType = value;
    }

    public void clearIdentifierType() {
      identifierType = null;
    }

    public void setSender(final Boolean value) {
      this.sender = value;
    }

    public void clearSender() {
      sender = null;
    }

    private void build(final JsonBuilder jsonBuilder) {
      jsonBuilder.writeStartObject();
      if (displayName != null) {
        jsonBuilder.writeFieldName(TestSchema.ACCOUNTS.DISPLAY_NAME.getFieldName());
        jsonBuilder.writeString(displayName);
      }
      if (handles != null) {
        jsonBuilder.writeFieldName(TestSchema.ACCOUNTS.HANDLES.getFieldName());
        jsonBuilder.writeStartArray();
        for(final String value : handles) {
          jsonBuilder.writeString(value);
        }
        jsonBuilder.writeEndArray();
      }
      if (identifier != null) {
        jsonBuilder.writeFieldName(TestSchema.ACCOUNTS.IDENTIFIER.getFieldName());
        jsonBuilder.writeString(identifier);
      }
      if (identifierType != null) {
        jsonBuilder.writeFieldName(TestSchema.ACCOUNTS.IDENTIFIER_TYPE.getFieldName());
        jsonBuilder.writeString(identifierType);
      }
      if (sender != null) {
        jsonBuilder.writeFieldName(TestSchema.ACCOUNTS.SENDER.getFieldName());
        jsonBuilder.writeBoolean(sender);
      }
      jsonBuilder.writeEndObject();
    }
  }

  public static final class EntitiesObjectBuilder {
    private String entityCategoryId;

    private List<String> entityId;

    private String grammarId;

    //nested object
    private List<MatchesObjectBuilder> matches;

    private EntitiesObjectBuilder() {
    }

    public void setEntityCategoryId(final String value) {
      this.entityCategoryId = value;
    }

    public void clearEntityCategoryId() {
      entityCategoryId = null;
    }

    public void setEntityId(final String... values) {
      this.entityId = Arrays.asList(values);
    }

    public void setEntityId(final List<String> values) {
      this.entityId = values;
    }

    public void addEntityId(final String value) {
      if (entityId == null) {
        this.entityId = new ArrayList<String>();
      }
      this.entityId.add(value);
    }

    public void setEntityId(final String value) {
        //same as clear followed by add
      this.entityId = new ArrayList<String>();
      this.entityId.add(value);
    }

    public void clearEntityId() {
      entityId = null;
    }

    public void setGrammarId(final String value) {
      this.grammarId = value;
    }

    public void clearGrammarId() {
      grammarId = null;
    }

    public void setMatches(final Consumer<MatchesObjectBuilder> builder) {
      //nested object
      final MatchesObjectBuilder matchesBuilder = new MatchesObjectBuilder();
      builder.accept(matchesBuilder);
      matches = new ArrayList<>();
      matches.add(matchesBuilder);
    }

    public void setMatches(final Stream<Consumer<MatchesObjectBuilder>> builders) {
      //nested object
        matches = builders.map(builder -> {
          final MatchesObjectBuilder matchesBuilder = new MatchesObjectBuilder();
          builder.accept(matchesBuilder);
          return matchesBuilder;
        }).collect(Collectors.toList());
    }

    public void setMatches(final List<Consumer<MatchesObjectBuilder>> builders) {
      //nested object
      setMatches(builders.stream());
    }

    public void clearMatches() {
      //nested object
      matches = null;
    }

    private void build(final JsonBuilder jsonBuilder) {
      jsonBuilder.writeStartObject();
      if (entityCategoryId == null) {
          //mandatory field not set
          throw new IllegalArgumentException("mandatory field 'entityCategoryId' is not set");
      } else {
          jsonBuilder.writeFieldName(TestSchema.ENTITIES.ENTITY_CATEGORY_ID.getFieldName());
          jsonBuilder.writeString(entityCategoryId);
      }
      if (entityId != null) {
        jsonBuilder.writeFieldName(TestSchema.ENTITIES.ENTITY_ID.getFieldName());
        jsonBuilder.writeStartArray();
        for(final String value : entityId) {
          jsonBuilder.writeString(value);
        }
        jsonBuilder.writeEndArray();
      }
      if (grammarId != null) {
        jsonBuilder.writeFieldName(TestSchema.ENTITIES.GRAMMAR_ID.getFieldName());
        jsonBuilder.writeString(grammarId);
      }
      if (matches != null) {
          //nested object
          jsonBuilder.writeFieldName(TestSchema.ENTITIES.MATCHES.getFieldName());
          jsonBuilder.writeStartArray();
          for(final MatchesObjectBuilder value : matches) {
            value.build(jsonBuilder);
          }
          jsonBuilder.writeEndArray();
        }
      jsonBuilder.writeEndObject();
    }

    public static final class MatchesObjectBuilder {
      private List<String> context;

      private String value;

      private Double score;

      private MatchesObjectBuilder() {
      }

      public void setContext(final String... values) {
        this.context = Arrays.asList(values);
      }

      public void setContext(final List<String> values) {
        this.context = values;
      }

      public void addContext(final String value) {
        if (context == null) {
          this.context = new ArrayList<String>();
        }
        this.context.add(value);
      }

      public void setContext(final String value) {
        if (context == null) {
          this.context = new ArrayList<String>();
        }
        this.context.add(value);
      }

      public void clearContext() {
        context = null;
      }

      public void setValue(final String value) {
        this.value = value;
      }

      public void clearValue() {
        value = null;
      }

      public void setScore(final Double value) {
        this.score = value;
      }

      public void clearScore() {
        score = null;
      }

      private void build(final JsonBuilder jsonBuilder) {
        jsonBuilder.writeStartObject();
        if (context != null) {
          jsonBuilder.writeFieldName(TestSchema.ENTITIES.MATCHES.CONTEXT.getFieldName());
          jsonBuilder.writeStartArray();
          for(final String value : context) {
            jsonBuilder.writeString(value);
          }
          jsonBuilder.writeEndArray();
        }
        if (value != null) {
          jsonBuilder.writeFieldName(TestSchema.ENTITIES.MATCHES.VALUE.getFieldName());
          jsonBuilder.writeString(value);
        }
        if (score != null) {
          jsonBuilder.writeFieldName(TestSchema.ENTITIES.MATCHES.SCORE.getFieldName());
          jsonBuilder.writeDouble(score);
        }
        jsonBuilder.writeEndObject();
      }
    }
  }

  public static final class MetadataFilesObjectBuilder {
    //TODO - flattened object
    private final SchemaObjectBuilder schemaObjectBuilder;

    private MetadataFilesObjectBuilder(final SchemaObjectBuilder schemaObjectBuilder) {
        this.schemaObjectBuilder=schemaObjectBuilder;
    }

    public void setContent(final String value) {
      schemaObjectBuilder.setStringFieldValue(TestSchema.METADATA_FILES.CONTENT, value);
    }

    public void clearContent() {
        schemaObjectBuilder.clearField(TestSchema.METADATA_FILES.CONTENT);
    }

    public void setExtension(final String value) {
        schemaObjectBuilder.setStringFieldValue(TestSchema.METADATA_FILES.EXTENSION, value);
    }

    public void clearExtension() {
        schemaObjectBuilder.clearField(TestSchema.METADATA_FILES.EXTENSION);
    }

  }

  public static final class OcrListObjectBuilder {
      //TODO - multi-dimension flattened object
      private List<OcrObjectBuilder> ocrBuilders;

      public void set(final Consumer<OcrObjectBuilder> builder) {
          final OcrObjectBuilder matchesBuilder = new OcrObjectBuilder();
          builder.accept(matchesBuilder);
          ocrBuilders = Collections.singletonList(matchesBuilder);
        }

        public void set(final Stream<Consumer<OcrObjectBuilder>> builders) {
            ocrBuilders = builders.map(builder -> {
              final OcrObjectBuilder matchesBuilder = new OcrObjectBuilder();
              builder.accept(matchesBuilder);
              return matchesBuilder;
            }).collect(Collectors.toList());
        }

        public void set(final List<Consumer<OcrObjectBuilder>> builders) {
          set(builders.stream());
        }

        public void clear() {
            ocrBuilders = null;
        }

        private void build(final JsonBuilder jsonBuilder) {
            jsonBuilder.writeStartArray();
          if (ocrBuilders != null) {
              for(final OcrObjectBuilder value : ocrBuilders) {
                value.build(jsonBuilder);
              }
            }
          jsonBuilder.writeEndArray();
        }
  }

  public static final class OcrObjectBuilder {
    private Integer confidence;

    private String name;

    private String type;

    private String value;

    private OcrObjectBuilder() {
    }

    public void setConfidence(final Integer value) {
      this.confidence = value;
    }

    public void clearConfidence() {
      confidence = null;
    }

    public void setName(final String value) {
      this.name = value;
    }

    public void clearName() {
      name = null;
    }

    public void setType(final String value) {
      this.type = value;
    }

    public void clearType() {
      type = null;
    }

    public void setValue(final String value) {
      this.value = value;
    }

    public void clearValue() {
      value = null;
    }

    private void build(final JsonBuilder jsonBuilder) {
      jsonBuilder.writeStartObject();
      if (confidence != null) {
        jsonBuilder.writeFieldName(TestSchema.OCR.CONFIDENCE.getFieldName());
        jsonBuilder.writeInteger(confidence);
      }
      if (name != null) {
        jsonBuilder.writeFieldName(TestSchema.OCR.NAME.getFieldName());
        jsonBuilder.writeString(name);
      }
      if (type != null) {
        jsonBuilder.writeFieldName(TestSchema.OCR.TYPE.getFieldName());
        jsonBuilder.writeString(type);
      }
      if (value != null) {
        jsonBuilder.writeFieldName(TestSchema.OCR.VALUE.getFieldName());
        jsonBuilder.writeString(value);
      }
      jsonBuilder.writeEndObject();
    }
  }
}
