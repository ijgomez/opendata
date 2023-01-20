package org.opendata.madrid.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.FilenameUtils;
import org.opendata.madrid.exceptions.OpenDataServiceException;
import org.opendata.madrid.helpers.ObjectHelper;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OpenDataService<E> {

    /**
     * Downloads a file from a URL
     * @param fileURL URL of the file to be downloaded
     * @param separator
     * @param skipHeader
     * @param transform
     * @return
     * @throws OpenDataServiceException
     */
    protected List<E> downloadCsvData(String fileURL, char separator, boolean skipHeader, Transform<E> transform) throws OpenDataServiceException {
    	HttpURLConnection httpConn = null;
    	try {
			List<E> result = new ArrayList<>();
			URL url = new URL(fileURL);
			httpConn = (HttpURLConnection) url.openConnection();
			int responseCode = httpConn.getResponseCode();
 
			// always check HTTP response code first
			if (responseCode == HttpURLConnection.HTTP_OK) {
			    log.debug("Content-Type = {}", httpConn.getContentType());
			    log.debug("Content-Length = {}", httpConn.getContentLength());

 
			    // opens input stream from the HTTP connection
			    try (InputStream inputStream = httpConn.getInputStream()) {
			        try (CSVReader reader = new CSVReaderBuilder(new InputStreamReader(inputStream))
			        		.withCSVParser(new CSVParserBuilder()
				                .withSeparator(separator)
				                .build()
				            )
			        		.withSkipLines((skipHeader) ? 1 : 0)
			        		.build()
			        	) {
			        	String[] line;
			            while ((line = reader.readNext()) != null) {
			                List<E> o = transform.toObject(line);
			                if (o != null) {
			                	result.addAll(o);
			                }
			            }
			        } 

			    }
 
			    log.debug("Csv file downloaded, and read {} registries.", result.size());
			} else {
			    log.debug("No Csv file to download. Server replied HTTP code: " + responseCode);
			}

			return result;
		} catch (Exception e) {
			throw new OpenDataServiceException("Fail read data in csv file: " + e.getMessage(), e);
		} finally {
			if (httpConn != null) {
				httpConn.disconnect();
			}
		}
    }
    
    
    protected <D> D downloadXmlData(String fileURL, Class<D> clazz) throws OpenDataServiceException {
    	HttpURLConnection httpConn = null;
    	try {

			D result = null;
			URL url = new URL(fileURL);
			httpConn = (HttpURLConnection) url.openConnection();
			int responseCode = httpConn.getResponseCode();
 
			// always check HTTP response code first
			if (responseCode == HttpURLConnection.HTTP_OK) {
			    log.debug("Content-Type = {}", httpConn.getContentType());
			    
			    // opens input stream from the HTTP connection
			    try (InputStream inputStream = httpConn.getInputStream()) {
			    	result = ObjectHelper.toObject(inputStream, clazz);
			    }
 
			    log.debug("Xml file downloaded");
			} else {
			    log.debug("No Xml file to download. Server replied HTTP code: " + responseCode);
			}
			
			return result;
		} catch (Exception e) {
			throw new OpenDataServiceException("Fail read data in xml file: " + e.getMessage(), e);
		} finally {
			if (httpConn != null) {
				httpConn.disconnect();
			}
		}
    }
    
    
    protected List<E> downloadZipData(String fileURL, char separator, boolean skipHeader, Transform<E> transform) throws OpenDataServiceException {
    	HttpURLConnection httpConn = null;
    	try {
			List<E> result = new ArrayList<>();
			URL url = new URL(fileURL);
			httpConn = (HttpURLConnection) url.openConnection();
			int responseCode = httpConn.getResponseCode();
 
			// always check HTTP response code first
			if (responseCode == HttpURLConnection.HTTP_OK) {
			    log.debug("Content-Type = {}", httpConn.getContentType());
 
			    // opens input stream from the HTTP connection
			    try (InputStream inputStream = httpConn.getInputStream()) {
			    	
			    	try (ZipInputStream zipIn = new ZipInputStream(inputStream)) {
			    		ZipEntry entry;
				        
				        while ((entry = zipIn.getNextEntry()) != null) {
				        	
				        String extension = FilenameUtils.getExtension(entry.getName());

				            if (extension.equals("csv")) {
				            	log.debug("{} - {}", extension, entry.getName());
				            	
				            	result.addAll(processCsvFile(zipIn, skipHeader, separator, transform));
				            	
				            }
				            zipIn.closeEntry();
				        }
			    	}

			    }
 
			    log.debug("Zip file downloaded, and read {} registries.", result.size());
			} else {
			    log.debug("No zip file to download. Server replied HTTP code: " + responseCode);
			}

			return result;
		} catch (Exception e) {
			throw new OpenDataServiceException("Fail read data in zip file: " + e.getMessage(), e);
		} finally {
			if (httpConn != null) {
				httpConn.disconnect();
			}
		}
    }


	private List<E> processCsvFile(ZipInputStream zipIn, boolean skipHeader, char separator, Transform<E> transform) throws IOException, CsvValidationException {
		List<E> result = new ArrayList<>();
		CSVReader reader = new CSVReaderBuilder(new InputStreamReader(zipIn))
				.withCSVParser(new CSVParserBuilder()
		            .withSeparator(separator)
		            .build()
		        )
				.withSkipLines((skipHeader) ? 1 : 0)
				.build();
		
			String[] line;
		    while ((line = reader.readNext()) != null) {
		        List<E> o = transform.toObject(line);
		        if (o != null) {
		        	result.addAll(o);
		        }
		    }
		 return result;
	}
    


}
