package com.fivestar.models.converters;

import android.database.Cursor;

import com.fivestar.models.Category;
import com.fivestar.models.columns.CategoryColumns;
import com.fivestar.tools.AbstractCursorConverter;

/**
 * Created by skuba on 19.03.2016.
 */
public class CategoryCursorConverter extends AbstractCursorConverter<Category> {
    private int COLUMN_INDEX_ID;
    private int COLUMN_INDEX_CATEGORY_TYPE;
    private int COLUMN_INDEX_CATEGORY_NAME;
    private int COLUMN_INDEX_COLOR;
    private int COLUMN_INDEX_ICON;

    @Override
    public void setCursor(Cursor cursor) {
        super.setCursor(cursor);
        if (isValid()) {
            COLUMN_INDEX_ID = cursor.getColumnIndex(CategoryColumns.ID);
            COLUMN_INDEX_CATEGORY_TYPE = cursor.getColumnIndex(CategoryColumns.TYPE);
            COLUMN_INDEX_CATEGORY_NAME = cursor.getColumnIndex(CategoryColumns.NAME);
            COLUMN_INDEX_COLOR = cursor.getColumnIndex(CategoryColumns.COLOR);
            COLUMN_INDEX_ICON = cursor.getColumnIndex(CategoryColumns.ICON);
        }
    }

    @Override
    public Category getObject() {
        Category category = null;
        if (isValid()) {
            category = new Category();
            category.setId(getCursor().getInt(COLUMN_INDEX_ID));
            category.setName(getCursor().getString(COLUMN_INDEX_CATEGORY_NAME));
            category.setType(getCursor().getString(COLUMN_INDEX_CATEGORY_TYPE));
            category.setColor(getCursor().getInt(COLUMN_INDEX_COLOR));
            category.setIcon(getCursor().getInt(COLUMN_INDEX_ICON));
        }
        return category;
    }
}
