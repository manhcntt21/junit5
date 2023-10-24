# NESTED CLASS
Dùng cho việc nhóm các phương thức theo một chức năng nào đó. Trong ví dụ, mô tả luồng của chức năng login.
- Tất cả các nested class phải là non-static
- Được chú thích với @Nested
- Không có giới hạn về chiều sâu của class
- Chỉ chứa @Test method và chỉ một @BeforeEach và một @AfterEach method
- @BeforeAll, @AfterAll không hoạt động trong @Nested