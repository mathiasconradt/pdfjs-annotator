/**
 * The MIT License (MIT)
 * <p/>
 * Copyright (c) 2015 Mathias Lin
 * <p/>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package pdfjsannotator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pdfjsannotator.model.annotation.Annotation;
import pdfjsannotator.model.annotation.SearchResult;
import pdfjsannotator.model.annotation.StoreMeta;
import pdfjsannotator.repository.AnnotationRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
public class AnnotationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnnotationController.class);

    @Autowired
    AnnotationRepository annotationRepository;

    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public StoreMeta root(HttpServletRequest request) {
        LOGGER.info("Requested annotator store API information.");
        return new StoreMeta("Annotator Store API", "2.0.0", request.getRemoteUser());
    }

    @RequestMapping(value = "/api/annotations", method = RequestMethod.GET)
    public Iterable<Annotation> index() {
        LOGGER.info("Requested list of annotations.");
        return annotationRepository.findAll();
    }

    //change properties of one comment using the id
    @RequestMapping(value = "/api/annotations", method = RequestMethod.POST)
    public Annotation create(@RequestBody Annotation annotation) {
        LOGGER.info("Requested creation of annotation: " + annotation.toString());
        if (annotation.getId() == null) {
            annotation.setId(UUID.randomUUID().toString());
            Timestamp ts = new Timestamp(Calendar.getInstance().getTimeInMillis());
            annotation.setCreated(ts);
            annotation.setUpdated(ts);
            annotation.setUser("Guest");
            annotation.setConsumer("pdfjs-annotator");
            annotation.setAnnotator_schema_version("v1.0");
        }
        return annotationRepository.save(annotation);
    }

    @RequestMapping(value = "/api/annotations", method = RequestMethod.DELETE)
    public void delete(HttpServletResponse response) {
        response.setStatus(204);
    }

    @RequestMapping(value = "/api/annotations/{id}", method = RequestMethod.GET)
    public Annotation read(@PathVariable String id) {
        LOGGER.info("Requested retrieval of annotation with id " + id);
        return annotationRepository.findById(id).get();
    }

    @RequestMapping(value = "/api/annotations/{id}", method = RequestMethod.PUT)
    public Annotation update(@PathVariable String id, @RequestBody Annotation annotation) {
        LOGGER.info("Requested update of annotation with id " + id);
        Optional<Annotation> oldAnnotation = annotationRepository.findById(id);
        oldAnnotation.get().setText(annotation.getText());
        oldAnnotation.get().setQuote(annotation.getQuote());
        oldAnnotation.get().setUpdated(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        return annotationRepository.save(oldAnnotation.get());
    }

    @RequestMapping(value = "/api/annotations/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id, HttpServletResponse response) {
        LOGGER.info("Requested deletion of annotation with id " + id);
        response.setStatus(204);
        annotationRepository.deleteById(id);
    }

    @RequestMapping(value = "/api/search", method = RequestMethod.GET)
    public SearchResult search(@RequestParam(required = false) String text,
                               @RequestParam(required = false) Integer limit,
                               @RequestParam(required = false) String uri) {
        SearchResult searchResult = new SearchResult();
        searchResult.setRows((List<Annotation>) annotationRepository.findByUri(uri));
        searchResult.setTotal(searchResult.getRows().size());
        return searchResult;
    }

}
