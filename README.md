# UserDataProcessor

## Описание

Приложение для ввода и проверки пользовательских данных, таких как фамилия, имя, отчество, дата рождения, номер телефона и пол. Программа проверяет правильность формата данных и записывает их в файл, если все данные введены корректно.

## Форматы данных

- Фамилия, имя, отчество: строки
- Дата рождения: строка формата `dd.mm.yyyy`
- Номер телефона: целое беззнаковое число без форматирования
- Пол: символ латиницей `f` или `m`

## Функциональность

- Проверка количества введенных данных.
- Проверка форматов данных.
- Запись данных в файл с именем, соответствующим фамилии.
- Обработка исключений и вывод сообщений об ошибках.

## Использование

1. Запустите приложение.
2. Введите данные в следующем формате, разделенные пробелами:
   ```
   Фамилия Имя Отчество датарождения номертелефона пол
   ```
3. Программа проверит введенные данные:
   - Если данных меньше или больше требуемого количества, будет выведено сообщение об ошибке.
   - Если данные имеют неправильный формат, будет выведено сообщение об ошибке.
   - Если все данные введены правильно, они будут записаны в файл `<Фамилия>.txt`.

## Примеры ввода

### Пример 1

**Ввод**:
```
Иванов Иван Иванович 15.04.1985 89101234567 m
```

**Вывод на экран**:
```
Result: Иванов Иван Иванович 15.04.1985 89101234567 m
```

**Содержимое файла `Иванов.txt`**:
```
Иванов Иван Иванович 15.04.1985 89101234567 m
```

### Пример 2

**Ввод**:
```
Петров Петр Петрович 01.01.1990 89001234567 f
```

**Вывод на экран**:
```
Result: Петров Петр Петрович 01.01.1990 89001234567 f
```

**Содержимое файла `Петров.txt`**:
```
Петров Петр Петрович 01.01.1990 89001234567 f
```

## Обработка ошибок

- Если введено меньше или больше 6 значений:
  ```
  Ошибка: Введено неверное количество данных. Требуется 6 значений.
  ```
- Если формат даты рождения неверный:
  ```
  Ошибка: Неверный формат даты рождения. Требуется формат dd.mm.yyyy.
  ```
- Если формат номера телефона неверный:
  ```
  Ошибка: Неверный формат номера телефона. Требуется целое число.
  ```
- Если формат пола неверный:
  ```
  Ошибка: Неверный формат пола. Требуется символ 'f' или 'm'.
  ```
- Если возникла ошибка при работе с файлом, выводится стектрейс ошибки.
