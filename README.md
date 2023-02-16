# Filters

## Overview
### Main view
Main view contains a switch to choose a mode: either modal or non-modal.
User can add a new filter by clicking "Add new filter" button.
User can view all the existing filters in the table.
### Adding a new filter
There are two modes: modal and non-modal. If the modal mode is selected, a dialog will appear where the user can add a new filter. If the non-modal mode is selected, the current view will be added a form where the user can add a new filter.
To add a new filter, user must insert the filter name, at least one criteria and select a "selection".
#### Criteria
Each criteria has a type: either "amount", "title" or "date".
For each type there are conditions the user can choose from (Equal to, more than, less than, before etc.).
If the chosen type is "amount", user must write a number in the third input.
If the chosen type is "title", user must write a text in the third input.
If the chosen type is "date", user must choose a date using the datepicker.
Each line of criteria can be removed by clicking the "-" button next to it. If all the criteria is removed, a new line of criteria will automatically be added.
The user can add criteria by clicking the button "Add row" - a new line will appear.
#### Saving, closing
User can save the entered data into database by clicking "Save".
In case the user does not want to save the data, it can click either "X" or "Cancel" and the form will disappear.
### Table
The table contains all the filters saved in database.
Each row shows filter name, criteria count, selection and an expansion button to view all the criteria.
If the user clicks the expansion button, a table of all this filter's criteria is shown.
Only one filter's criteria can be shown at a time - the previous one will be closed when the user open a new one.
The filter's table is sortable on all the column and has pagination.

### Note
Note that there is currently no way of editing an existing filter or deleting one.
