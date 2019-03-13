package com.agileengine.test;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Analyzer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Analyzer.class);
    private static final String SEPARATOR = ">";

    public static void parseTargetFile(String[] args) {

        String originFilePath = args[0];
        String sampleFilePath = args[1];
        String targetElementId;
        if (args.length == 3) {
            targetElementId = args[2];
        } else {
            targetElementId="make-everything-ok-button";
        }

        File originFile = new File(originFilePath);
        File sampleFile = new File(sampleFilePath);

        LOGGER.info("Original file - {}.", originFilePath);
        LOGGER.info("Sample file - {}.", sampleFilePath);

        Optional<Element> elementOptional = JsoupUtils.findElementById(originFile, targetElementId);
        if (elementOptional.isPresent()) {
            Element element = elementOptional.get();
            LOGGER.info("Found element in original file: {}.", element);

            Optional<Elements> sampleFileElements = JsoupUtils.findElementsByQuery(sampleFile, element.tagName());
            if (sampleFileElements.isPresent()) {
                Optional<Element> bestMatchingElementOptional =
                        findSimilarElement(sampleFileElements.get(), element);
                if (bestMatchingElementOptional.isPresent()) {
                    String pathToBestMatchingElement =
                            buildPathToElement(bestMatchingElementOptional.get());
                    LOGGER.info("Path to the best matching element - {}", pathToBestMatchingElement);
                }
            } else {
                LOGGER.info("Element not found in sample file");
            }
        } else {
            LOGGER.error("In the original file element not found. Id - {}", targetElementId);
        }
    }

    public static Optional<Element> findSimilarElement(Elements elements, Element baseElement) {
        Element similarElement = null;
        int maxNumberEqualAttributes = 0;
        Map<String, String> baseElementAttributes = getElementAttributes(baseElement);
        for (Element element: elements) {
            Map<String, String> elementAttributes = getElementAttributes(element);
            int numberEqualAttributes = getNumberOfEqualAttributes(elementAttributes, baseElementAttributes);
            if (numberEqualAttributes > maxNumberEqualAttributes) {
                similarElement = element;
                maxNumberEqualAttributes = numberEqualAttributes;
            }
        }
        if (maxNumberEqualAttributes > 0) {
            LOGGER.info("The best matching element - {}", similarElement);
        } else {
            LOGGER.info("The best matching element not found");
        }
        LOGGER.info("Number of matches - {}", maxNumberEqualAttributes);
        return Optional.ofNullable(similarElement);
    }

    private static int getNumberOfEqualAttributes(Map<String, String> testElementAttributes,
                                                  Map<String, String> baseElementAttributes) {
        int number = 0;
        for (Map.Entry<String, String> entry : testElementAttributes.entrySet()) {
            String k = entry.getKey();
            String v = entry.getValue();
            if (baseElementAttributes.containsKey(k) && baseElementAttributes.get(k).equals(v)) {
                number++;
            }
        }
        return number;
    }

    public static Map<String, String> getElementAttributes(Element element) {
        return element.attributes().asList().stream()
                .collect(Collectors.toMap(Attribute::getKey, Attribute::getValue));
    }

    public static String buildPathToElement(Element element) {
        StringBuilder path = new StringBuilder(element.tagName());
        element.parents().stream().forEachOrdered(p -> {
            path.append(SEPARATOR);
            path.append(p.tag());
        });
        return path.toString();
    }
}