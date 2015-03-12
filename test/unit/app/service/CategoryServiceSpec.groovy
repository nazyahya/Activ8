package app.service

import app.event.CategoryService
import grails.test.mixin.TestFor
import org.junit.Assert
import spock.lang.Specification
import app.event.Category;

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(CategoryService)
class CategoryServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }
    private void createMockCategory(){
        Category category = new Category();
        category.setName("asd");
    }
    void "Test category creation"() {
        Category mockCategory = createMockCategory();
        CategoryService categoryService = new CategoryService();
        //Create category
        int categoryId = categoryService.addCategory(mockCategory);
        //Retrieve created category
        Category retrievedCategory = categoryService.getCategoryById(categoryId);
        Assert.assertEquals(retrievedCategory.getName(), mockCategory.getName());
        //Delete created category
        categoryService.deleteCategory(retrievedCategory);
    }
   /* void "Test category creation"() {
        Category mockCategory = createMockCategory();
        CategoryService categoryService = new CategoryService();
        //Create category
        int categoryId = categoryService.addCategory(mockCategory);
        //Retrieve created category
        Category retrievedCategory = categoryService.getCategoryById(categoryId);
        Assert.assertEquals(retrievedCategory.getName(), mockCategory.getName());
        //Delete created category
        categoryService.deleteCategory(retrievedCategory);
    }
    getAllCategories();
    public Category getCategoryById(int id);//Returns categoryId
    public List<Category> getCategoryByFilter(CategoryFilter filter);
    public int addCategory(Category category);
    public void deleteCategory(Category category);
    public void updateCategory(Category category);
    public void addEventToCategory(Category category, Event event);
 */
}
