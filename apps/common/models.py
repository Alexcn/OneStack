from django.db import models

# Create your models here.


class BaseModel(models.Model):
    created_at = models.DateTimeField(auto_now_add=True, verbose_name='创建时间')
    updated_at = models.DateTimeField(auto_now=True, verbose_name='修改时间')

    class Meta:
        abstract = True


class Server(BaseModel):
    class Meta:
        abstract = True


class SoftWare(BaseModel):
    class Meta:
        abstract = True

