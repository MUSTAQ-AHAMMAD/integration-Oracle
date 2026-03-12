package innovate.tamergroup.fusion;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseId;
import javax.faces.model.SelectItem;

import javax.servlet.http.HttpServletRequest;

import oracle.adf.controller.ControllerContext;
import oracle.adf.controller.TaskFlowContext;
import oracle.adf.controller.TaskFlowTrainModel;
import oracle.adf.controller.TaskFlowTrainStopModel;
import oracle.adf.controller.ViewPortContext;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.model.binding.DCParameter;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.fragment.RichRegion;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;
import oracle.binding.ControlBinding;
import oracle.binding.OperationBinding;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.uicli.binding.JUCtrlValueBinding;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;


public class ADFBeanUtils {
    
    public static final ADFLogger LOGGER = ADFLogger.createADFLogger(ADFBeanUtils.class);
    private static final String NO_RESOURCE_FOUND = "Missing resource: ";

    /**
     * Get application module for an application module data control by name.
     * @param name application module data control name
     * @return ApplicationModule
     */
    public static ApplicationModule getApplicationModuleForDataControl(String name) {
        return (ApplicationModule) resolveExpression("#{data." + name + ".dataProvider}");
    }

    /**
     * A convenience method for getting the value of a bound attribute in the
     * current page context programatically.
     * @param attributeName of the bound value in the pageDef
     * @return value of the attribute
     */
    public static Object getBoundAttributeValue(String attributeName) {
        return findControlBinding(attributeName).getInputValue();
    }

    /**
     * A convenience method for setting the value of a bound attribute in the
     * context of the current page.
     * @param attributeName of the bound value in the pageDef
     * @param value to set
     */
    public static void setBoundAttributeValue(String attributeName, Object value) {
        findControlBinding(attributeName).setInputValue(value);
    }

    /**
     * Returns the evaluated value of a pageDef parameter.
     * @param pageDefName reference to the page definition file of the page with the parameter
     * @param parameterName name of the pagedef parameter
     * @return evaluated value of the parameter as a String
     */
    public static Object getPageDefParameterValue(String pageDefName, String parameterName) {
        BindingContainer bindings = findBindingContainer(pageDefName);
        DCParameter param = ((DCBindingContainer) bindings).findParameter(parameterName);
        return param.getValue();
    }

    /**
     * Convenience method to find a DCControlBinding as an AttributeBinding
     * to get able to then call getInputValue() or setInputValue() on it.
     * @param bindingContainer binding container
     * @param attributeName name of the attribute binding.
     * @return the control value binding with the name passed in.
     *
     */
    public static AttributeBinding findControlBinding(BindingContainer bindingContainer, String attributeName) {
        if (attributeName != null) {
            if (bindingContainer != null) {
                ControlBinding ctrlBinding = bindingContainer.getControlBinding(attributeName);
                if (ctrlBinding instanceof AttributeBinding) {
                    return (AttributeBinding) ctrlBinding;
                }
            }
        }
        return null;
    }

    /**
     * Convenience method to find a DCControlBinding as a JUCtrlValueBinding
     * to get able to then call getInputValue() or setInputValue() on it.
     * @param attributeName name of the attribute binding.
     * @return the control value binding with the name passed in.
     *
     */
    public static AttributeBinding findControlBinding(String attributeName) {
        return findControlBinding(getBindingContainer(), attributeName);
    }

    /**
     * Return the current page's binding container.
     * @return the current page's binding container
     */
    public static BindingContainer getBindingContainer() {
        return (BindingContainer) resolveExpression("#{bindings}");
    }

    /**
     * Return the Binding Container as a DCBindingContainer.
     * @return current binding container as a DCBindingContainer
     */
    public static DCBindingContainer getDCBindingContainer() {
        return (DCBindingContainer) getBindingContainer();
    }

    /**
     * Get List of ADF Faces SelectItem for an iterator binding.
     *
     * Uses the value of the 'valueAttrName' attribute as the key for
     * the SelectItem key.
     *
     * @param iteratorName ADF iterator binding name
     * @param valueAttrName name of the value attribute to use
     * @param displayAttrName name of the attribute from iterator rows to display
     * @return ADF Faces SelectItem for an iterator binding
     */
    public static List<SelectItem> selectItemsForIterator(String iteratorName, String valueAttrName,
                                                          String displayAttrName) {
        return selectItemsForIterator(findIterator(iteratorName), valueAttrName, displayAttrName);
    }

    /**
     * Get List of ADF Faces SelectItem for an iterator binding with description.
     *
     * Uses the value of the 'valueAttrName' attribute as the key for
     * the SelectItem key.
     *
     * @param iteratorName ADF iterator binding name
     * @param valueAttrName name of the value attribute to use
     * @param displayAttrName name of the attribute from iterator rows to display
     * @param descriptionAttrName name of the attribute to use for description
     * @return ADF Faces SelectItem for an iterator binding with description
     */
    public static List<SelectItem> selectItemsForIterator(String iteratorName, String valueAttrName,
                                                          String displayAttrName, String descriptionAttrName) {
        return selectItemsForIterator(findIterator(iteratorName), valueAttrName, displayAttrName, descriptionAttrName);
    }

    /**
     * Get List of attribute values for an iterator.
     * @param iteratorName ADF iterator binding name
     * @param valueAttrName value attribute to use
     * @return List of attribute values for an iterator
     */
    public static List attributeListForIterator(String iteratorName, String valueAttrName) {
        return attributeListForIterator(findIterator(iteratorName), valueAttrName);
    }

    /**
     * Get List of Key objects for rows in an iterator.
     * @param iteratorName iterabot binding name
     * @return List of Key objects for rows
     */
    public static List<Key> keyListForIterator(String iteratorName) {
        return keyListForIterator(findIterator(iteratorName));
    }

    /**
     * Get List of Key objects for rows in an iterator.
     * @param iter iterator binding
     * @return List of Key objects for rows
     */
    public static List<Key> keyListForIterator(DCIteratorBinding iter) {
        List<Key> attributeList = new ArrayList<Key>();
        for (Row r : iter.getAllRowsInRange()) {
            attributeList.add(r.getKey());
        }
        return attributeList;
    }

    /**
     * Get List of Key objects for rows in an iterator using key attribute.
     * @param iteratorName iterator binding name
     * @param keyAttrName name of key attribute to use
     * @return List of Key objects for rows
     */
    public static List<Key> keyAttrListForIterator(String iteratorName, String keyAttrName) {
        return keyAttrListForIterator(findIterator(iteratorName), keyAttrName);
    }

    /**
     * Get List of Key objects for rows in an iterator using key attribute.
     *
     * @param iter iterator binding
     * @param keyAttrName name of key attribute to use
     * @return List of Key objects for rows
     */
    public static List<Key> keyAttrListForIterator(DCIteratorBinding iter, String keyAttrName) {
        List<Key> attributeList = new ArrayList<Key>();
        for (Row r : iter.getAllRowsInRange()) {
            attributeList.add(new Key(new Object[] { r.getAttribute(keyAttrName) }));
        }
        return attributeList;
    }

    /**
     * Get a List of attribute values for an iterator.
     *
     * @param iter iterator binding
     * @param valueAttrName name of value attribute to use
     * @return List of attribute values
     */
    public static List attributeListForIterator(DCIteratorBinding iter, String valueAttrName) {
        List attributeList = new ArrayList();
        for (Row r : iter.getAllRowsInRange()) {
            attributeList.add(r.getAttribute(valueAttrName));
        }
        return attributeList;
    }

    /**
     * Find an iterator binding in the current binding container by name.
     *
     * @param name iterator binding name
     * @return iterator binding
     */
    public static DCIteratorBinding findIterator(String name) {
        DCIteratorBinding iter = getDCBindingContainer().findIteratorBinding(name);
        if (iter == null) {
            throw new RuntimeException("Iterator '" + name + "' not found");
        }
        return iter;
    }

    /**
     * @param bindingContainer
     * @param iterator
     * @return
     */
    public static DCIteratorBinding findIterator(String bindingContainer, String iterator) {
        DCBindingContainer bindings = (DCBindingContainer) resolveExpression("#{" + bindingContainer + "}");
        if (bindings == null) {
            throw new RuntimeException("Binding container '" + bindingContainer + "' not found");
        }
        DCIteratorBinding iter = bindings.findIteratorBinding(iterator);
        if (iter == null) {
            throw new RuntimeException("Iterator '" + iterator + "' not found");
        }
        return iter;
    }

    /**
     * @param name
     * @return
     */
    public static JUCtrlValueBinding findCtrlBinding(String name) {
        JUCtrlValueBinding rowBinding = (JUCtrlValueBinding) getDCBindingContainer().findCtrlBinding(name);
        if (rowBinding == null) {
            throw new RuntimeException("CtrlBinding " + name + "' not found");
        }
        return rowBinding;
    }

    /**
     * Find an operation binding in the current binding container by name.
     *
     * @param name operation binding name
     * @return operation binding
     */
    public static OperationBinding findOperation(String name) {
        OperationBinding op = getDCBindingContainer().getOperationBinding(name);
        if (op == null) {
            throw new RuntimeException("Operation '" + name + "' not found");
        }
        return op;
    }

    /**
     * Find an operation binding in the current binding container by name.
     *
     * @param bindingContianer binding container name
     * @param opName operation binding name
     * @return operation binding
     */
    public static OperationBinding findOperation(String bindingContianer, String opName) {
        DCBindingContainer bindings = (DCBindingContainer) resolveExpression("#{" + bindingContianer + "}");
        if (bindings == null) {
            throw new RuntimeException("Binding container '" + bindingContianer + "' not found");
        }
        OperationBinding op = bindings.getOperationBinding(opName);
        if (op == null) {
            throw new RuntimeException("Operation '" + opName + "' not found");
        }
        return op;
    }

    /**
     * Get List of ADF Faces SelectItem for an iterator binding with description.
     *
     * Uses the value of the 'valueAttrName' attribute as the key for
     * the SelectItem key.
     *
     * @param iter ADF iterator binding
     * @param valueAttrName name of value attribute to use for key
     * @param displayAttrName name of the attribute from iterator rows to display
     * @param descriptionAttrName name of the attribute for description
     * @return ADF Faces SelectItem for an iterator binding with description
     */
    public static List<SelectItem> selectItemsForIterator(DCIteratorBinding iter, String valueAttrName,
                                                          String displayAttrName, String descriptionAttrName) {
        List<SelectItem> selectItems = new ArrayList<SelectItem>();
        for (Row r : iter.getAllRowsInRange()) {
            selectItems.add(new SelectItem(r.getAttribute(valueAttrName), (String) r.getAttribute(displayAttrName),
                                           (String) r.getAttribute(descriptionAttrName)));
        }
        return selectItems;
    }

    /**
     * Get List of ADF Faces SelectItem for an iterator binding.
     *
     * Uses the value of the 'valueAttrName' attribute as the key for
     * the SelectItem key.
     *
     * @param iter ADF iterator binding
     * @param valueAttrName name of value attribute to use for key
     * @param displayAttrName name of the attribute from iterator rows to display
     * @return ADF Faces SelectItem for an iterator binding
     */
    public static List<SelectItem> selectItemsForIterator(DCIteratorBinding iter, String valueAttrName,
                                                          String displayAttrName) {
        List<SelectItem> selectItems = new ArrayList<SelectItem>();
        for (Row r : iter.getAllRowsInRange()) {
            selectItems.add(new SelectItem(r.getAttribute(valueAttrName), (String) r.getAttribute(displayAttrName)));
        }
        return selectItems;
    }

    /**
     * Get List of ADF Faces SelectItem for an iterator binding.
     *
     * Uses the rowKey of each row as the SelectItem key.
     *
     * @param iteratorName ADF iterator binding name
     * @param displayAttrName name of the attribute from iterator rows to display
     * @return ADF Faces SelectItem for an iterator binding
     */
    public static List<SelectItem> selectItemsByKeyForIterator(String iteratorName, String displayAttrName) {
        return selectItemsByKeyForIterator(findIterator(iteratorName), displayAttrName);
    }

    /**
     * Get List of ADF Faces SelectItem for an iterator binding with discription.
     *
     * Uses the rowKey of each row as the SelectItem key.
     *
     * @param iteratorName ADF iterator binding name
     * @param displayAttrName name of the attribute from iterator rows to display
     * @param descriptionAttrName name of the attribute for description
     * @return ADF Faces SelectItem for an iterator binding with discription
     */
    public static List<SelectItem> selectItemsByKeyForIterator(String iteratorName, String displayAttrName,
                                                               String descriptionAttrName) {
        return selectItemsByKeyForIterator(findIterator(iteratorName), displayAttrName, descriptionAttrName);
    }

    /**
     * Get List of ADF Faces SelectItem for an iterator binding with discription.
     *
     * Uses the rowKey of each row as the SelectItem key.
     *
     * @param iter ADF iterator binding
     * @param displayAttrName name of the attribute from iterator rows to display
     * @param descriptionAttrName name of the attribute for description
     * @return ADF Faces SelectItem for an iterator binding with discription
     */
    public static List<SelectItem> selectItemsByKeyForIterator(DCIteratorBinding iter, String displayAttrName,
                                                               String descriptionAttrName) {
        List<SelectItem> selectItems = new ArrayList<SelectItem>();
        for (Row r : iter.getAllRowsInRange()) {
            selectItems.add(new SelectItem(r.getKey(), (String) r.getAttribute(displayAttrName),
                                           (String) r.getAttribute(descriptionAttrName)));
        }
        return selectItems;
    }

    /**
     * Get List of ADF Faces SelectItem for an iterator binding.
     *
     * Uses the rowKey of each row as the SelectItem key.
     *
     * @param iter ADF iterator binding
     * @param displayAttrName name of the attribute from iterator rows to display
     * @return List of ADF Faces SelectItem for an iterator binding
     */
    public static List<SelectItem> selectItemsByKeyForIterator(DCIteratorBinding iter, String displayAttrName) {
        List<SelectItem> selectItems = new ArrayList<SelectItem>();
        for (Row r : iter.getAllRowsInRange()) {
            selectItems.add(new SelectItem(r.getKey(), (String) r.getAttribute(displayAttrName)));
        }
        return selectItems;
    }

    /**
     * Find the BindingContainer for a page definition by name.
     *
     * Typically used to refer eagerly to page definition parameters. It is
     * not best practice to reference or set bindings in binding containers
     * that are not the one for the current page.
     *
     * @param pageDefName name of the page defintion XML file to use
     * @return BindingContainer ref for the named definition
     */
    private static BindingContainer findBindingContainer(String pageDefName) {
        BindingContext bctx = getDCBindingContainer().getBindingContext();
        BindingContainer foundContainer = bctx.findBindingContainer(pageDefName);
        return foundContainer;
    }

    /**
     * @param opList
     */
    public static void printOperationBindingExceptions(List opList) {
        if (opList != null && !opList.isEmpty()) {
            for (Object error : opList) {
                LOGGER.severe(error.toString());
            }
        }
    }

    /**
     * Method for taking a reference to a JSF binding expression and returning
     * the matching object (or creating it).
     * @param expression EL expression
     * @return Managed object
     */
    public static Object resolveExpression(String expression) {
        FacesContext facesContext = getFacesContext();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        ValueExpression valueExp = elFactory.createValueExpression(elContext, expression, Object.class);
        return valueExp.getValue(elContext);
    }

    public static String resolveRemoteUser() {
        FacesContext facesContext = getFacesContext();
        ExternalContext ectx = facesContext.getExternalContext();
        return ectx.getRemoteUser();
    }

    public static String resolveUserPrincipal() {
        FacesContext facesContext = getFacesContext();
        ExternalContext ectx = facesContext.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ectx.getRequest();
        return request.getUserPrincipal().getName();
    }

    public static Object resloveMethodExpression(String expression, Class returnType, Class[] argTypes,
                                                 Object[] argValues) {
        FacesContext facesContext = getFacesContext();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        MethodExpression methodExpression =
            elFactory.createMethodExpression(elContext, expression, returnType, argTypes);
        return methodExpression.invoke(elContext, argValues);
    }

    /**
     * Method for taking a reference to a JSF binding expression and returning
     * the matching Boolean.
     * @param expression EL expression
     * @return Managed object
     */
    public static Boolean resolveExpressionAsBoolean(String expression) {
        return (Boolean) resolveExpression(expression);
    }

    /**
     * Method for taking a reference to a JSF binding expression and returning
     * the matching String (or creating it).
     * @param expression EL expression
     * @return Managed object
     */
    public static String resolveExpressionAsString(String expression) {
        return (String) resolveExpression(expression);
    }

    /**
     * Convenience method for resolving a reference to a managed bean by name
     * rather than by expression.
     * @param beanName name of managed bean
     * @return Managed object
     */
    public static Object getManagedBeanValue(String beanName) {
        StringBuffer buff = new StringBuffer("#{");
        buff.append(beanName);
        buff.append("}");
        return resolveExpression(buff.toString());
    }

    /**
     * Method for setting a new object into a JSF managed bean
     * Note: will fail silently if the supplied object does
     * not match the type of the managed bean.
     * @param expression EL expression
     * @param newValue new value to set
     */
    public static void setExpressionValue(String expression, Object newValue) {
        FacesContext facesContext = getFacesContext();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        ValueExpression valueExp = elFactory.createValueExpression(elContext, expression, Object.class);

        //Check that the input newValue can be cast to the property type
        //expected by the managed bean.
        //If the managed Bean expects a primitive we rely on Auto-Unboxing
        //I could do a more comprehensive check and conversion from the object
        //to the equivilent primitive but life is too short
        Class bindClass = valueExp.getType(elContext);
        if (bindClass.isPrimitive() || bindClass.isInstance(newValue)) {
            valueExp.setValue(elContext, newValue);
        }
    }

    /**
     * Convenience method for setting the value of a managed bean by name
     * rather than by expression.
     * @param beanName name of managed bean
     * @param newValue new value to set
     */
    public static void setManagedBeanValue(String beanName, Object newValue) {
        StringBuffer buff = new StringBuffer("#{");
        buff.append(beanName);
        buff.append("}");
        setExpressionValue(buff.toString(), newValue);
    }


    /**
     * Convenience method for setting Session variables.
     * @param key object key
     * @param object value to store
     */

    public static void storeOnSession(String key, Object object) {
        FacesContext ctx = getFacesContext();
        Map sessionState = ctx.getExternalContext().getSessionMap();
        sessionState.put(key, object);
    }

    /**
     * Convenience method for getting Session variables.
     * @param key object key
     * @return session object for key
     */
    public static Object getFromSession(String key) {
        FacesContext ctx = getFacesContext();
        Map sessionState = ctx.getExternalContext().getSessionMap();
        return sessionState.get(key);
    }

    public static String getFromHeader(String key) {
        FacesContext ctx = getFacesContext();
        ExternalContext ectx = ctx.getExternalContext();
        return ectx.getRequestHeaderMap().get(key);
    }

    /**
     * Convenience method for getting Request variables.
     * @param key object key
     * @return session object for key
     */
    public static Object getFromRequest(String key) {
        FacesContext ctx = getFacesContext();
        Map sessionState = ctx.getExternalContext().getRequestMap();
        return sessionState.get(key);
    }

    /**
     * Pulls a String resource from the property bundle that
     * is defined under the application &lt;message-bundle&gt; element in
     * the faces config. Respects Locale
     * @param key string message key
     * @return Resource value or placeholder error String
     */
    public static String getStringFromBundle(String key) {
        ResourceBundle bundle = getBundle();
        return getStringSafely(bundle, key, null);
    }


    /**
     * Convenience method to construct a <code>FacesMesssage</code>
     * from a defined error key and severity
     * This assumes that the error keys follow the convention of
     * using <b>_detail</b> for the detailed part of the
     * message, otherwise the main message is returned for the
     * detail as well.
     * @param key for the error message in the resource bundle
     * @param severity severity of message
     * @return Faces Message object
     */
    public static FacesMessage getMessageFromBundle(String key, FacesMessage.Severity severity) {
        ResourceBundle bundle = getBundle();
        String summary = getStringSafely(bundle, key, null);
        String detail = getStringSafely(bundle, key + "_detail", summary);
        FacesMessage message = new FacesMessage(summary, detail);
        message.setSeverity(severity);
        return message;
    }

    /**
     * Add JSF info message.
     * @param msg info message string
     */
    public static void addFacesInformationMessage(String msg) {
        FacesContext ctx = getFacesContext();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, "");
        ctx.addMessage(getRootViewComponentId(), fm);
    }

    /**
     * Add JSF error message.
     * @param msg error message string
     */
    public static void addFacesErrorMessage(String msg) {
        FacesContext ctx = getFacesContext();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, "");
        ctx.addMessage(getRootViewComponentId(), fm);
    }

    /**
     * Add JSF error message for a specific attribute.
     * @param attrName name of attribute
     * @param msg error message string
     */
    public static void addFacesErrorMessage(String attrName, String msg) {
        // TODO: Need a way to associate attribute specific messages
        //       with the UIComponent's Id! For now, just using the view id.
        //TODO: make this use the internal getMessageFromBundle?
        FacesContext ctx = getFacesContext();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, attrName, msg);
        ctx.addMessage(getRootViewComponentId(), fm);
    }

    // Informational getters

    /**
     * Get view id of the view root.
     * @return view id of the view root
     */
    public static String getRootViewId() {
        return getFacesContext().getViewRoot().getViewId();
    }

    /**
     * Get component id of the view root.
     * @return component id of the view root
     */
    public static String getRootViewComponentId() {
        return getFacesContext().getViewRoot().getId();
    }

    /**
     * Get FacesContext.
     * @return FacesContext
     */
    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }
    /*
        * Internal method to pull out the correct local
        * message bundle
        */

    private static ResourceBundle getBundle() {
        FacesContext ctx = getFacesContext();
        UIViewRoot uiRoot = ctx.getViewRoot();
        Locale locale = uiRoot.getLocale();
        ClassLoader ldr = Thread.currentThread().getContextClassLoader();
        return ResourceBundle.getBundle(ctx.getApplication().getMessageBundle(), locale, ldr);
    }

    /**
     * Get an HTTP Request attribute.
     * @param name attribute name
     * @return attribute value
     */
    public static Object getRequestAttribute(String name) {
        return getFacesContext().getExternalContext().getRequestMap().get(name);
    }

    /**
     * Set an HTTP Request attribute.
     * @param name attribute name
     * @param value attribute value
     */
    public static void setRequestAttribute(String name, Object value) {
        getFacesContext().getExternalContext().getRequestMap().put(name, value);
    }

    /*
        * Internal method to proxy for resource keys that don't exist
        */

    private static String getStringSafely(ResourceBundle bundle, String key, String defaultValue) {
        String resource = null;
        try {
            resource = bundle.getString(key);
        } catch (MissingResourceException mrex) {
            if (defaultValue != null) {
                resource = defaultValue;
            } else {
                resource = NO_RESOURCE_FOUND + key;
            }
        }
        return resource;
    }

    /**
     * Locate an UIComponent in view root with its component id. Use a recursive way to achieve this.
     * Taken from http://www.jroller.com/page/mert?entry=how_to_find_a_uicomponent
     * @param id UIComponent id
     * @return UIComponent object
     */
    public static UIComponent findComponentInRoot(String id) {
        UIComponent component = null;
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (facesContext != null) {
            UIComponent root = facesContext.getViewRoot();
            component = findComponent(root, id);
        }
        return component;
    }

    /**
     * Locate an UIComponent from its root component.
     * Taken from http://www.jroller.com/page/mert?entry=how_to_find_a_uicomponent
     * @param base root Component (parent)
     * @param id UIComponent id
     * @return UIComponent object
     */
    public static UIComponent findComponent(UIComponent base, String id) {
        if (id.equals(base.getId()))
            return base;

        UIComponent children = null;
        UIComponent result = null;
        Iterator childrens = base.getFacetsAndChildren();
        while (childrens.hasNext() && (result == null)) {
            children = (UIComponent) childrens.next();
            if (id.equals(children.getId())) {
                result = children;
                break;
            }
            result = findComponent(children, id);
            if (result != null) {
                break;
            }
        }
        return result;
    }

    /**
     * Method to create a redirect URL. The assumption is that the JSF servlet mapping is
     * "faces", which is the default
     *
     * @param view the JSP or JSPX page to redirect to
     * @return a URL to redirect to
     */
    public static String getPageURL(String view) {
        FacesContext facesContext = getFacesContext();
        ExternalContext externalContext = facesContext.getExternalContext();
        String url = ((HttpServletRequest) externalContext.getRequest()).getRequestURL().toString();
        StringBuffer newUrlBuffer = new StringBuffer();
        newUrlBuffer.append(url.substring(0, url.lastIndexOf("faces/")));
        newUrlBuffer.append("faces");
        String targetPageUrl = view.startsWith("/") ? view : "/" + view;
        newUrlBuffer.append(targetPageUrl);
        return newUrlBuffer.toString();
    }

    public static void displayInfoMessage(String message) {
        FacesMessage msg = new FacesMessage("", message);
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public static void displayErrorMessage(String message) {
        FacesMessage msg = new FacesMessage("", message);
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public static void returnFromDialog() {
        AdfFacesContext.getCurrentInstance().returnFromDialog(null, null);
    }

    public static void returnFromDialog(Map params) {
        AdfFacesContext.getCurrentInstance().returnFromDialog(null, params);
    }

    /**
     * Method for taking a reference to a JSF binding expression and returning
     * the matching object (or creating it).
     * @param expression EL expression
     * @return Managed object
     */
    public static Object resolveExpressionInScriptlet(String expression) {
        FacesContext facesContext = getFacesContext();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        ValueExpression valueExp =
            elFactory.createValueExpression(elContext, "#{sessionScope." + expression + "}", Object.class);
        return valueExp.getValue(elContext);
    }

    public static void openInSeparateWindow(String url) {
        ExtendedRenderKitService erk =
            Service.getRenderKitService(FacesContext.getCurrentInstance(), ExtendedRenderKitService.class);
        StringBuilder str = new StringBuilder("window.open('" + url + "');");
        erk.addScript(FacesContext.getCurrentInstance(), str.toString());
    }

    public static void openInTheSameWindow(String url) {
        ExtendedRenderKitService erk =
            Service.getRenderKitService(FacesContext.getCurrentInstance(), ExtendedRenderKitService.class);
        StringBuilder str = new StringBuilder("window.open('" + url + "','_self');");
        erk.addScript(FacesContext.getCurrentInstance(), str.toString());
    }

    
    
    public static ResourceBundle getResourceBundle(String resourceBundlePath) {  
    
      return ResourceBundle.getBundle(resourceBundlePath, getFacesContext().getViewRoot().getLocale());  
    }  
    
    public static String getMessageBundleKey(String resourceBundlePath, String key) {  
      ResourceBundle bundle = getResourceBundle(resourceBundlePath);  
      return getResourceBundleKey(bundle, key);  
    }  
    
    private static String getResourceBundleKey(ResourceBundle resourceBundle, String key) {  
      String bundleKeyValue;  
      try {  
        bundleKeyValue = resourceBundle.getString(key);  
      } catch (MissingResourceException mrExp) {  
        bundleKeyValue = key + " not found in resource bundle";  
      }  
      return bundleKeyValue;  
    }  

    public Object invokeMethodExpression(String expr, Class returnType, Class[] argTypes, Object[] args) {
        FacesContext fc = FacesContext.getCurrentInstance();
        ELContext elctx = fc.getELContext();
        ExpressionFactory elFactory = fc.getApplication().getExpressionFactory();
        MethodExpression methodExpr = elFactory.createMethodExpression(elctx, expr, returnType, argTypes);
        return methodExpr.invoke(elctx, args);
    }

    public Object invokeMethodExpression(String expr, Class returnType, Class argType, Object argument) {
        return invokeMethodExpression(expr, returnType, new Class[] { argType }, new Object[] { argument });
    }


    public static void printRemoteUserInfo() {
        System.out.println("Remote Address :" +
                           ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemoteAddr());
        System.out.println("Remote Host :" +
                           ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemoteHost());
        System.out.println("Remote Port :" +
                           ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemotePort());
        System.out.println("Remote User :" +
                           ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemoteUser());
    }

    public static String getRemoteHost() {
        return ((HttpServletRequest) (FacesContext.getCurrentInstance().getExternalContext().getRequest())).getRemoteHost();
    }

    public static String getRemoteAddress() {
        return ((HttpServletRequest) (FacesContext.getCurrentInstance().getExternalContext().getRequest())).getRemoteAddr();
    }


    public static UIComponent getComponent(String componentId) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        Iterator iter = ctx.getViewRoot().getChildren().iterator();

        while (iter.hasNext()) {

            UIComponent component = (UIComponent) iter.next();
            UIComponent targetComponent = getComponent(component, componentId);
            if (targetComponent != null) {
                return targetComponent;
            }
        }

        return null;
    }


    private static UIComponent getComponent(UIComponent uiComponent, String componentId) {

        UIComponent targetComponent = uiComponent.findComponent(componentId);
        if (targetComponent != null)
            return targetComponent;

        Iterator iter = uiComponent.getFacetsAndChildren();
        while (iter.hasNext()) {
            UIComponent component = (UIComponent) iter.next();
            UIComponent target = getComponent(component, componentId);
            if (target != null)
                return target;
        }
        return null;
    }


    public static void openPopup(String sourceFieldId, String popupId) {
        // Add event code here...
        UIComponent sourceDateField = getComponent(sourceFieldId);
        UIComponent popupComponent = getComponent(popupId);
        FacesContext ctx = FacesContext.getCurrentInstance();
        ExtendedRenderKitService service = Service.getRenderKitService(ctx, ExtendedRenderKitService.class);
        service.addScript(ctx, "var hints = new Object();");
        service.addScript(ctx, "hints[AdfRichPopup.HINT_ALIGN_ID] ='" + sourceDateField.getClientId() + "';");
        service.addScript(ctx, "hints[AdfRichPopup.HINT_ALIGN] = AdfRichPopup.ALIGN_OVERLAP ;");
        service.addScript(ctx, "AdfPage.PAGE.findComponent('" + popupComponent.getClientId() + "').show(hints);");
    }

    public static void openPopup(String popupId) {
        RichPopup popup = (RichPopup) getComponent(popupId);
        popup.show(new RichPopup.PopupHints());
    }

    public static void openPopup(String popupId, String alignComponentId, String alignType) {
        RichPopup pp = (RichPopup) getComponent(popupId);
        UIComponent alignComponent = getComponent(alignComponentId);

        RichPopup.PopupHints hints = new RichPopup.PopupHints();

        if (alignType.equals("ALIGN_AFTER_START")) {
            hints.add(RichPopup.PopupHints.HintTypes.HINT_ALIGN_ID,
                      alignComponent.getClientId()).add(RichPopup.PopupHints.HintTypes.HINT_ALIGN,
                                                        RichPopup.PopupHints.AlignTypes.ALIGN_AFTER_START);
        }
        if (alignType.equals("ALIGN_OVERLAP")) {
            hints.add(RichPopup.PopupHints.HintTypes.HINT_ALIGN_ID,
                      alignComponent.getClientId()).add(RichPopup.PopupHints.HintTypes.HINT_ALIGN,
                                                        RichPopup.PopupHints.AlignTypes.ALIGN_OVERLAP);
        }
        if (alignType.equals("ALIGN_BEFORE_START")) {
            hints.add(RichPopup.PopupHints.HintTypes.HINT_ALIGN_ID,
                      alignComponent.getClientId()).add(RichPopup.PopupHints.HintTypes.HINT_ALIGN,
                                                        RichPopup.PopupHints.AlignTypes.ALIGN_BEFORE_START);
        }
        if (alignType.equals("ALIGN_BEFORE_END")) {
            hints.add(RichPopup.PopupHints.HintTypes.HINT_ALIGN_ID,
                      alignComponent.getClientId()).add(RichPopup.PopupHints.HintTypes.HINT_ALIGN,
                                                        RichPopup.PopupHints.AlignTypes.ALIGN_BEFORE_END);
        }
        if (alignType.equals("ALIGN_AFTER_END")) {
            hints.add(RichPopup.PopupHints.HintTypes.HINT_ALIGN_ID,
                      alignComponent.getClientId()).add(RichPopup.PopupHints.HintTypes.HINT_ALIGN,
                                                        RichPopup.PopupHints.AlignTypes.ALIGN_AFTER_END);
        }

        pp.show(hints);
    }


    public static void executeOperationBindings(String operationName) {
        getBindings().getOperationBinding(operationName).execute();
    }

    public static BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public static void refreshThisComponent(String componentId) {
        AdfFacesContext.getCurrentInstance().addPartialTarget(getComponent(componentId));
    }

    //
    //    public static void openPopupWithHintProgrammaticaly(String popupId, String alignComponentId,
    //                                                        String alighOrientation) {
    //
    //        if (alighOrientation.equals("after_end")) {
    //            UIComponent position = getComponent(alignComponentId);
    //            RichPopup.PopupHints hints = new RichPopup.PopupHints();
    //            hints.add(RichPopup.PopupHints.HintTypes.HINT_ALIGN_ID,
    //                      position.getClientId()).add(RichPopup.PopupHints.HintTypes.HINT_ALIGN_ID,
    //                                                  RichPopup.PopupHints.AlignTypes.ALIGN_AFTER_END);
    //            RichPopup pp = (RichPopup)getComponent(popupId);
    //            pp.show(hints);
    //        } else {
    //            UIComponent position = getComponent(alignComponentId);
    //            RichPopup.PopupHints hints = new RichPopup.PopupHints();
    //            hints.add(RichPopup.PopupHints.HintTypes.HINT_ALIGN_ID,
    //                      position.getClientId()).add(RichPopup.PopupHints.HintTypes.HINT_ALIGN_ID,
    //                                                  RichPopup.PopupHints.AlignTypes.ALIGN_BEFORE_START);
    //            RichPopup pp = (RichPopup)getComponent(popupId);
    //            pp.show(hints);
    //        }
    //    }


    //    public static void showPopup() {
    //           // Add event code here...
    //           String alignComponentId = (String)resolveExpression("#{requestScope.alignComponentId}");
    //           String popupId = (String)resolveExpression("#{requestScope.popupComponentId}");
    //           UIComponent alignComponent = getComponent(alignComponentId);
    //           UIComponent popupComponent = getComponent(popupId);
    //           FacesContext ctx = FacesContext.getCurrentInstance();
    //           ExtendedRenderKitService service = Service.getRenderKitService(ctx, ExtendedRenderKitService.class);
    //           service.addScript(ctx, "var hints = new Object();");
    //           service.addScript(ctx, "hints[AdfRichPopup.HINT_ALIGN_ID] ='" + alignComponent.getClientId() + "';");
    //           service.addScript(ctx, "hints[AdfRichPopup.HINT_ALIGN] = AdfRichPopup.ALIGN_AFTER_END ;");
    //           service.addScript(ctx, "AdfPage.PAGE.findComponent('" + popupComponent.getClientId() + "').show(hints);");
    //
    //       }

    //    public static void openPopupWithHintByJavaScript(String popupId, String alignComponentId, String alignType) {
    //        FacesContext fc = FacesContext.getCurrentInstance();
    //        ExtendedRenderKitService erks = Service.getRenderKitService(fc, ExtendedRenderKitService.class);
    //        erks.addScript(fc, " var hints = new Object();");
    //        erks.addScript(fc," hints[AdfRichPopup.HINT_ALIGN_ID] ='" + getComponent(alignComponentId).getClientId() + "';");
    //        erks.addScript(fc, " hints[AdfRichPopup.HINT_ALIGN] = AdfRichPopup.ALIGN_AFTER_END ;");
    //        erks.addScript(fc, " AdfPage.PAGE.findComponent('" + getComponent(popupId).getClientId() + "').show(hints);");
    //    }

    public static void displayView(String viewId) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        UIViewRoot newPage = ctx.getApplication().getViewHandler().createView(ctx, viewId);
        ctx.setViewRoot(newPage);
        ctx.renderResponse();
    }

    public static void logViewCriteriaSelectStatement(ViewObjectImpl view, String viewCriteriaName) {
        String searchStmt = view.getViewCriteria(viewCriteriaName).getClauses().getClauseForQuery();
        for (int i = 0; i < view.getWhereClauseParams().length; i++) {
            Object[] criteriaRow = (Object[]) (view.getWhereClauseParams()[i]);
            String name = (String) criteriaRow[0];
            String value = criteriaRow[1].toString();
            searchStmt = searchStmt.replaceFirst(":" + name, value);
            System.out.println(name + " " + value);
        }
        System.out.println(searchStmt);
        displayInfoMessage(searchStmt);
    }

    public static String getInitialContextParameterValue(String contextParamName) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) ctx.getExternalContext().getRequest();
        return request.getSession().getServletContext().getInitParameter(contextParamName);
    }


    //    public static void downloadAttachement(OutputStream outputStream , String iteratorName ,String contentAttrName ) throws NamingException,
    //                                                                                             IOException {
    //           // the value is a BlobDomain data type
    //           BlobDomain blob = (BlobDomain)Utils.findIterator(iteratorName).getCurrentRow().getAttribute(contentAttrName);
    //           // copy hte data from the BlobDomain to the output stream
    //           IOUtils.copy(blob.getInputStream(), outputStream);
    //           // cloase the blob to release the recources
    //           blob.closeInputStream();
    //           // flush the outout stream
    //           outputStream.flush();
    //
    //       }


    //    public static void downloadAttachement(OutputStream outputStream , BlobDomain blob ) throws NamingException,
    //                                                                                             IOException {
    //
    //           // copy hte data from the BlobDomain to the output stream
    //           IOUtils.copy(blob.getInputStream(), outputStream);
    //           // cloase the blob to release the recources
    //           blob.closeInputStream();
    //           // flush the outout stream
    //           outputStream.flush();
    //
    //       }

    //    public static String uploadAttachement(String inputFileId , String iteratorName ,
    //                                    String contentAttrName , String contentFileAttrName ,
    //                                    String contentFileAttrTypeName) {
    //
    //           RichInputFile inputFile = (RichInputFile)getComponent(inputFileId);
    //           UploadedFile file = (UploadedFile)inputFile.getValue();
    //
    //
    //
    //           if(file!=null)
    //           {
    //               Row row = Utils.findIterator(iteratorName).getCurrentRow();
    //               row.setAttribute(contentAttrName, createBlobDomain(file));
    //               row.setAttribute(contentFileAttrName, file.getFilename());
    //               row.setAttribute(contentFileAttrTypeName, file.getContentType());
    //               inputFile.resetValue();
    //               AdfFacesContext.getCurrentInstance().addPartialTarget(inputFile);
    //               }
    //           return null;
    //       }

    //
    //       private static BlobDomain createBlobDomain(UploadedFile file) {
    //           // init the internal variables
    //           InputStream in = null;
    //           BlobDomain blobDomain = null;
    //           OutputStream out = null;
    //
    //           try {
    //               // Get the input stream representing the data from the client
    //               in = file.getInputStream();
    //               // create the BlobDomain datatype to store the data in the db
    //               blobDomain = new BlobDomain();
    //               // get the outputStream for hte BlobDomain
    //               out = blobDomain.getBinaryOutputStream();
    //               // copy the input stream into the output stream
    //               /*
    //                           * IOUtils is a class from the Apache Commons IO Package (http://www.apache.org/)
    //                           * Here version 2.0.1 is used
    //                           * please download it directly from http://projects.apache.org/projects/commons_io.html
    //                           */
    //               IOUtils.copy(in, out);
    //           } catch (IOException e) {
    //               e.printStackTrace();
    //           } catch (SQLException e) {
    //               e.fillInStackTrace();
    //           }
    //
    //           // return the filled BlobDomain
    //           return blobDomain;
    //       }


    public static void navigateToNextTrainStop(ActionEvent actionEvent) {
        UIComponent eventOriginComponent = (UIComponent) actionEvent.getSource();
        RichRegion region = null;
        //find region
        UIComponent current = eventOriginComponent;
        while (current.getParent() != null) {
            current = current.getParent();
            if (current instanceof RichRegion) {
                region = (RichRegion) current;
                break;
            }
        }
        if (region != null) {
            ControllerContext controllerContext = ControllerContext.getInstance();
            ViewPortContext currentViewPortCtx = controllerContext.getCurrentViewPort();
            TaskFlowContext taskFlowCtx = currentViewPortCtx.getTaskFlowContext();
            TaskFlowTrainModel taskFlowTrainModel = taskFlowCtx.getTaskFlowTrainModel();
            TaskFlowTrainStopModel currentStop = taskFlowTrainModel.getCurrentStop();
            TaskFlowTrainStopModel nextStop = taskFlowTrainModel.getNextStop(currentStop);
            if (nextStop != null) {
                String nextStopActionStr = nextStop.getOutcome();
                //queue action
                region.queueActionEventInRegion(createMethodExpressionFromString(nextStopActionStr), null, null, false,
                                                new Integer(0), new Integer(0), PhaseId.INVOKE_APPLICATION);
            }
        }
    }


    public static MethodExpression createMethodExpressionFromString(String s) {
        FacesContext fctx = FacesContext.getCurrentInstance();
        ELContext elctx = fctx.getELContext();
        ExpressionFactory exprFactory = fctx.getApplication().getExpressionFactory();
        MethodExpression methodExpr = exprFactory.createMethodExpression(elctx, s, null, new Class[] { });
        return methodExpr;
    }


    //    public static void writeBufferedImageAsJPEG(OutputStream servletOutputStream, File imageFile) throws IOException {
    //        // defer argument checking...
    //        BufferedImage bufferedImage = ImageIO.read(imageFile);
    //        //bufferedImage.setRGB(128, 128, BufferedImage.TYPE_INT_RGB);
    //        writeBufferedImageAsJPEG(servletOutputStream, 0.75f, bufferedImage);
    //    }
    //
    //    public static void writeBufferedImageAsJPEG(OutputStream out, float quality,
    //                                                BufferedImage image) throws IOException {
    //        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
    //        JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(image);
    //        param.setQuality(quality, true);
    //        encoder.encode(image, param);
    //
    //    }


    // public static void commitAndRetainCurrentPersonRow()
    // {
    //        ViewObjectImpl obj = (ViewObjectImpl)ADFJSFUtils.findIterator("IisPersonsView1Iterator").getViewObject();
    //        Key key = new Key(new Object[] { (Number)obj.getCurrentRow().getAttribute("PersonCode") });
    //        Row[] rows = obj.findByKey(key, 1);
    //        executeOperationBindings("Commit");
    //        obj.setCurrentRow(rows[0]);
    //     }

    public static void displayCustomizedJqueryInfoMessage(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        ExtendedRenderKitService erks = Service.getService(context.getRenderKit(), ExtendedRenderKitService.class);
        erks.addScript(context, "showNotificationCallback('" + msg + "')");

    }

}


