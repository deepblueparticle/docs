package com.sismics.docs.core.util.format;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Format handler utilities.
 *
 * @author bgamard
 */
public class FormatHandlerUtil {
    /**
     * List of format handlers.
     */
    private static final List<Class<? extends FormatHandler>> FORMAT_HANDLERS = Lists.newArrayList(
            DocxFormatHandler.class,
            OdtFormatHandler.class,
            VideoFormatHandler.class,
            PdfFormatHandler.class,
            TextPlainFormatHandler.class,
            ImageFormatHandler.class
    );

    /**
     * Find a suitable format handler for this MIME type.
     *
     * @param mimeType MIME type
     * @return Instancied format handler
     */
    public static FormatHandler find(String mimeType) {
        try {
            for (Class<? extends FormatHandler> formatHandlerClass : FORMAT_HANDLERS) {
                FormatHandler formatHandler = formatHandlerClass.newInstance();
                if (formatHandler.accept(mimeType)) {
                    return formatHandler;
                }
            }
        } catch (InstantiationException | IllegalAccessException e) {
            return null;
        }

        return null;
    }
}
