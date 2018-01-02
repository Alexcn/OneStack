from django.db import models

# Create your models here.

from django.db import models
from django.contrib.auth.models import AbstractUser, Group, Permission, PermissionsMixin
from django.core.validators import RegexValidator


class AuthSource(models.Model):
    class Meta:
        db_table = 'auth_sources'

    auth_type = models.CharField(max_length=30)
    name = models.CharField(max_length=60)
    host = models.CharField(max_length=120, default='')
    port = models.IntegerField(default=None)
    account = models.CharField(max_length=60, default='')
    account_password = models.CharField(max_length=255, default='')
    base_dn = models.CharField(max_length=255, default=None)
    tls = models.BooleanField(default=False)
    timeout = models.IntegerField(default=5)


class User(AbstractUser):
    class Meta:
        db_table = 'users'
    auth_source = models.ForeignKey(AuthSource, default=None, null=True)
