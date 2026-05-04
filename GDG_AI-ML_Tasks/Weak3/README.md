# Logistic Regression for Cancer Detection

## Objective
Predict whether a tumor is benign or malignant using Logistic Regression based on medical features from the Breast Cancer dataset. Evaluate the model's performance and analyze its results.

## Dataset
The dataset includes the following features:
- Clump Thickness
- Uniformity of Cell Size
- Uniformity of Cell Shape
- Marginal Adhesion
- Single Epithelial Cell Size
- Bare Nuclei
- Bland Chromatin
- Normal Nucleoli
- Mitoses
- Class (Target: 2 = benign, 4 = malignant)

Non-informative columns (e.g., Sample Code Number) were removed.

## Steps Performed
1. Loaded and inspected the dataset.
2. Handled missing values by replacing `?` with median values.
3. Dropped non-informative columns.
4. Separated features (X) and target (y).
5. Split the dataset into training (70%) and testing (30%) sets.
6. Scaled the features using StandardScaler.
7. Trained a Logistic Regression model on the training data.
8. Made predictions on the test set.
9. Evaluated performance using:
   - Accuracy score
   - Confusion matrix
   - Classification report (precision, recall, F1-score)

## Results
- The model achieved high accuracy on the test set.
- Confusion matrix and classification report show the model effectively distinguishes benign and malignant tumors.
- Logistic Regression proves effective for binary classification on structured medical data.

## Conclusion
Logistic Regression can reliably predict tumor class when the data is clean and properly preprocessed. Performance can be further enhanced with feature engineering or more advanced models.


1. Open the notebook in Google Colab.
2. Upload the `breast_cancer.csv` dataset.
3. Run all cells sequentially to reproduce results.
Or you can use the .csv file and the .py files to see what happens.
