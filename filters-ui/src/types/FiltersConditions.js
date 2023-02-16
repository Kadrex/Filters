export const filterTypes = [
    'AMOUNT', 'TITLE', 'DATE'
];

export const filterConditionsByType = {
    'AMOUNT': ['MORE', 'LESS', 'EQUAL', 'NOT_EQUAL'],
    'TITLE': ['STARTS_WITH', 'ENDS_WITH', 'CONTAINS', 'DOES_NOT_CONTAIN'],
    'DATE': ['FROM', 'TO', 'AT']
};

export const stringRepresentation = {
    'AMOUNT': 'Amount',
    'TITLE': 'Title',
    'DATE': 'Date',
    'MORE': 'More than',
    'LESS': 'Less than',
    'EQUAL': 'Equal to',
    'NOT_EQUAL': 'Not equal to',
    'STARTS_WITH': 'Starts with',
    'ENDS_WITH': 'Ends with',
    'CONTAINS': 'Contains',
    'DOES_NOT_CONTAIN': 'Does not contain',
    'FROM': 'From',
    'TO': 'To',
    'AT': 'At'
};
