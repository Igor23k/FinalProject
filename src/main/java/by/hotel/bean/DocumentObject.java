package by.hotel.bean;

/**
 * DocumentObject.java
 * The class store objects with properties to create documents.
 * @author Igor Kozlov
 * @version 1.0
 */
public class DocumentObject {
    /**
     * Property - mimeType
     */
    private String mimeType;
    /**
     * Property - documentName
     */
    private String documentName;
    /**
     * Property - array of documentBytes
     */
    private byte[] documentBytes;

    /**
     * Function for get value {@link DocumentObject#documentName}
     * @return value of documentName
     */
    public String getDocumentName() {
        return documentName;
    }

    /**
     * Function for set value of documentName {@link DocumentObject#documentName}
     * @param documentName - the documentName to be set.
     */
    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    /**
     * Function for get value {@link DocumentObject#mimeType}
     * @return value of mimeType
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * Function for set value of mimeType {@link DocumentObject#mimeType}
     * @param mimeType - the mimeType to be set.
     */
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    /**
     * Function for get value {@link DocumentObject#documentBytes}
     * @return value of documentBytes
     */
    public byte[] getDocumentBytes() {
        return documentBytes;
    }

    /**
     * Function for set value of id {@link DocumentObject#documentBytes}
     * @param documentBytes - the documentBytes to be set.
     */
    public void setDocumentBytes(byte[] documentBytes) {
        this.documentBytes = documentBytes;
    }
}
