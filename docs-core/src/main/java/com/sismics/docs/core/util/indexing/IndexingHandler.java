package com.sismics.docs.core.util.indexing;

import com.sismics.docs.core.constant.PermType;
import com.sismics.docs.core.dao.criteria.DocumentCriteria;
import com.sismics.docs.core.dao.dto.DocumentDto;
import com.sismics.docs.core.model.jpa.Document;
import com.sismics.docs.core.model.jpa.File;
import com.sismics.docs.core.util.jpa.PaginatedList;
import com.sismics.docs.core.util.jpa.SortCriteria;

import java.util.List;

/**
 * Indexing handler.
 *
 * @author bgamard
 */
public interface IndexingHandler {
    /**
     * Return true if this indexing handler can start.
     *
     * @return True if able to start
     */
    boolean accept();

    /**
     * Start the indexing handler.
     *
     * @throws Exception e
     */
    void startUp() throws Exception;

    /**
     * Shutdown the indexing handler.
     */
    void shutDown();

    /**
     * Fully rebuild the index.
     *
     * @param documentList All documents
     * @param fileList All files
     */
    void rebuildIndex(List<Document> documentList, List<File> fileList);

    /**
     * Index a new document.
     *
     * @param document Document
     */
    void createDocument(Document document);

    /**
     * Index a new file.
     *
     * @param file File
     */
    void createFile(File file);

    /**
     * Update an indexed document.
     *
     * @param document Document
     */
    void updateDocument(Document document);

    /**
     * Update an indexed file.
     *
     * @param file File
     */
    void updateFile(File file);

    /**
     * Delete a file or a document.
     *
     * @param id ID
     */
    void deleteDocument(String id);

    /**
     * Create an ACL.
     *
     * @param sourceId Source ID
     * @param perm Permission type
     * @param targetId Target ID
     */
    void createAcl(String sourceId, PermType perm, String targetId);

    /**
     * Delete an ACL.
     *
     * @param sourceId Source ID
     * @param perm Permission type
     * @param targetId Target ID
     */
    void deleteAcl(String sourceId, PermType perm, String targetId);

    /**
     * Searches documents by criteria.
     *
     * @param paginatedList List of documents (updated by side effects)
     * @param criteria Search criteria
     * @param sortCriteria Sort criteria
     * @throws Exception e
     */
    void findByCriteria(PaginatedList<DocumentDto> paginatedList, DocumentCriteria criteria, SortCriteria sortCriteria) throws Exception;
}
